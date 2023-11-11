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
            today -> today.between(1, 25),
            (today, orders) -> 1000 + (today.getToday() - 1) * 100
    ),
    WEEKDAY(
            "평일 할인",
            Today::isWeekday,
            (today, orders) -> orders.getCourseCount(Course.DESSERT) * 2023
    ),
    WEEKEND(
            "주말 할인",
            Today::isWeekend,
            (today, orders) -> orders.getCourseCount(Course.MAIN) * 2023
    ),
    SPECIAL(
            "특별 할인",
            today -> today.isChristmas() || today.isSunday(),
            (today, orders) -> 1000
    );

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

    public static List<DiscountEvent> getAvailableEvents(Today today) {
        return Arrays.stream(DiscountEvent.values())
                .filter(discountEvent -> discountEvent.validator.apply(today))
                .toList();
    }

    public Discount getDiscount(Today today, Orders orders) {
        return new Discount(eventName, discountCalculator.apply(today, orders));
    }

}
