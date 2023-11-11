package christmas.controller;

import christmas.constant.Badge;
import christmas.constant.DiscountEvent;
import christmas.constant.GiveawayEvent;
import christmas.domain.*;
import christmas.domain.Discount.Discounts;
import christmas.domain.Discount.DiscountsBuilder;
import christmas.domain.Order.Orders;
import christmas.service.OrderService;
import christmas.service.TodayService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ChristmasController {

    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;
    private final TodayService todayService;


    public ChristmasController(
            InputView inputView,
            OutputView outputView,
            OrderService orderService,
            TodayService todayService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
        this.todayService = todayService;
    }

    public void play() {

        outputView.printHeader();

        Today today = getToday();
        Orders orders = getOrders();

        GiveawayEvents giveawayEvents = getGiveawayEvents(orders);
        DiscountEvents discountEvents = getDiscountEvents(today, orders);
        Discounts discounts = getDiscounts(discountEvents, giveawayEvents, today, orders);
        Badge badge = getBadge(discounts);

        printReceipt(orders, giveawayEvents, discounts, badge);

    }

    private Today getToday() {
        return tryCatchLoop(() -> todayService.createToday(inputView.getToday()));
    }

    private Orders getOrders() {
        return tryCatchLoop(() -> orderService.createOrders(inputView.getOrders()));
    }

    private Badge getBadge(Discounts discounts) {
        return Badge.findBadge(discounts.getTotalDiscounts());
    }

    private GiveawayEvents getGiveawayEvents(Orders orders) {
        return new GiveawayEvents(
                GiveawayEvent.getAvailableEvents(orders.getTotalPrice())
        );
    }

    private DiscountEvents getDiscountEvents(Today today, Orders orders) {
        return new DiscountEvents(
                DiscountEvent.getAvailableEvents(today, orders.getTotalPrice())
        );
    }

    private Discounts getDiscounts(
            DiscountEvents discountEvents,
            GiveawayEvents giveawayEvents,
            Today today,
            Orders orders
    ) {
        DiscountsBuilder discountsBuilder = new DiscountsBuilder();
        discountsBuilder.add(discountEvents.getDiscounts(today, orders));
        discountsBuilder.add(giveawayEvents.getDiscounts());
        return discountsBuilder.build();
    }

    private void printReceipt(
            Orders orders,
            GiveawayEvents giveawayEvents,
            Discounts discounts,
            Badge badge
    ) {
        outputView.printEventPreviewMessage();
        outputView.printOrderedMenus(orders.getOrderedMenusMessage());
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());
        outputView.printGiveaway(giveawayEvents.getGiveawayMessage());
        outputView.printDiscounts(discounts.getDiscountMessage());
        outputView.printTotalDiscounts(discounts.getTotalDiscounts());
        outputView.printTotalPriceAfterDiscount(orders.getTotalPrice() + discounts.getTotalDiscounts());
        outputView.printBadge(badge.getBadgeName());
    }

    private <T> T tryCatchLoop(Supplier<T> supplier) {
        return tryCatchLoop(supplier, outputView::printIllegalArgumentException);
    }

    private <T> T tryCatchLoop(
            Supplier<T> supplier,
            Consumer<IllegalArgumentException> exceptionConsumer
    ) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                exceptionConsumer.accept(e);
            }
        }
    }

}
