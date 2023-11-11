package christmas.constant;

import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.domain.Today;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum DiscountEvent {

    CHRISTMAS_D_DAY(
            "크리스마스 디데이 할인",
            today -> today.is(Calender.BEFORE_CHRISTMAS),
            (today, orders) -> Constants.D_DAY_DISCOUNT_BASE + (today.getToday() - 1) * Constants.D_DAY_DISCOUNT_PER_DAY
    ),
    WEEKDAY(
            "평일 할인",
            today -> today.is(Calender.WEEKDAY),
            (today, orders) -> orders.getCourseCount(Course.DESSERT) * Constants.DESSERT_MAIN_DISH_DISCOUNT
    ),
    WEEKEND(
            "주말 할인",
            today -> today.is(Calender.WEEKEND),
            (today, orders) -> orders.getCourseCount(Course.MAIN) * Constants.DESSERT_MAIN_DISH_DISCOUNT
    ),
    SPECIAL(
            "특별 할인",
            today -> today.is(Calender.CHRISTMAS) || today.is(Calender.SUNDAY),
            (today, orders) -> 1000
    );

    public static final int PRICE_LOWER_BOUND = 10_000;
    private final String eventName;
    private final Function<Today, Boolean> validator;
    private final BiFunction<Today, Orders, Integer> discountCalculator;

    DiscountEvent(
            String eventName,
            Function<Today, Boolean> validator,
            BiFunction<Today, Orders, Integer> discountCalculator
    ) {
        this.eventName = eventName;
        this.validator = validator;
        this.discountCalculator = discountCalculator;
    }

    public static List<DiscountEvent> getAvailableEvents(Today today, int price) {
        if (price < PRICE_LOWER_BOUND) {
            return List.of();
        }
        return Arrays.stream(DiscountEvent.values())
                .filter(discountEvent -> discountEvent.validator.apply(today))
                .toList();
    }

    public Discount getDiscount(Today today, Orders orders) {
        return new Discount(eventName, discountCalculator.apply(today, orders));
    }

    private static class Constants {
        public static final int DESSERT_MAIN_DISH_DISCOUNT = 2023;
        public static final int D_DAY_DISCOUNT_BASE = 1000;
        public static final int D_DAY_DISCOUNT_PER_DAY = 100;
    }
}
