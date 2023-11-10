package christmas.constant;

import christmas.domain.DiscountEvents;
import christmas.domain.Today;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum DiscountEvent {

    CHRISTMAS_D_DAY(today -> today.between(1, 25)),
    WEEKDAY(Today::isWeekday),
    WEEKEND(Today::isWeekend),
    SPECIAL(today -> today.isChristmas() || today.isSunday());

    private final Function<Today, Boolean> validator;

    DiscountEvent(Function<Today, Boolean> validator) {
        this.validator = validator;
    }

    public static DiscountEvents getAvailableEvents(Today today) {
        List<DiscountEvent> discountEvents = Arrays.stream(DiscountEvent.values())
                .filter(discountEvent -> discountEvent.validator.apply(today))
                .toList();
        return new DiscountEvents(discountEvents);
    }

}
