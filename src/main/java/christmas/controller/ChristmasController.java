package christmas.controller;

import christmas.constant.Badge;
import christmas.constant.DiscountEvent;
import christmas.constant.GiveawayEvent;
import christmas.domain.*;
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

        Today today = tryCatchLoop(() -> todayService.createToday(inputView.getToday()));
        Orders orders = tryCatchLoop(() -> orderService.createOrders(inputView.getOrders()));

        GiveawayEvents giveawayEvents = new GiveawayEvents(GiveawayEvent.getAvailableEvents(orders.getTotalPrice()));
        DiscountEvents discountEvents = new DiscountEvents(DiscountEvent.getAvailableEvents(today));

        Discounts discounts = new Discounts();
        discounts.add(discountEvents.getDiscounts(today, orders));
        discounts.add(giveawayEvents.getDiscounts());

        Badge badge = Badge.findBadge(discounts.getTotalDiscounts());

        outputView.printEventPreviewMessage();
        outputView.printOrderedMenus(orders.getOrderedMenusMessage());
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());
        outputView.printGiveaway(giveawayEvents.getGiveawayMessage());
        outputView.printDiscounts(discounts.getDiscountMessage());
        outputView.printTotalDiscounts(discounts.getTotalDiscounts());
        outputView.printTotalPriceAfterDiscount(orders.getTotalPrice() - discounts.getTotalDiscounts());
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
