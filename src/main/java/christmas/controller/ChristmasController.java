package christmas.controller;

import christmas.constant.Badge;
import christmas.domain.Discount.Discounts;
import christmas.domain.Event.Events;
import christmas.domain.Event.EventsBuilder;
import christmas.domain.Giveaway.Giveaways;
import christmas.domain.Order.Orders;
import christmas.domain.Today;
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
        Events events = getEvents(today, orders);

        Discounts totalDiscounts = events.getTotalDiscounts();
        Giveaways giveaways = events.getGiveaways();
        Badge badge = Badge.findBadge(totalDiscounts.getTotalDiscounts());
        Discounts actualDiscounts = events.getDiscountsExceptGiveaways();

        printReceipt(orders, giveaways, totalDiscounts, actualDiscounts, badge);

    }

    private static Events getEvents(Today today, Orders orders) {
        return new EventsBuilder()
                .today(today)
                .orders(orders)
                .build();
    }

    private void printReceipt(
            Orders orders,
            Giveaways giveaways,
            Discounts totalDiscounts,
            Discounts actualDiscounts,
            Badge badge
    ) {
        outputView.printEventPreviewMessage();
        outputView.printOrderedMenus(orders.getOrderedMenusMessage());
        outputView.printTotalPriceBeforeDiscount(orders.getTotalPrice());
        outputView.printGiveaway(giveaways.getGiveawayMessage());
        outputView.printDiscountsMessage(totalDiscounts.getDiscountsMessage());
        outputView.printTotalDiscounts(totalDiscounts.getTotalDiscounts());
        outputView.printTotalPriceAfterDiscount(orders.getTotalPrice() + actualDiscounts.getTotalDiscounts());
        outputView.printBadge(badge.getBadgeName());
    }

    private Today getToday() {
        return tryCatchLoop(() -> todayService.createToday(inputView.getToday()));
    }

    private Orders getOrders() {
        return tryCatchLoop(() -> orderService.createOrders(inputView.getOrders()));
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
