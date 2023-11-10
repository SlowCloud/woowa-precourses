package christmas.constant;

import christmas.domain.Today;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum DiscountEvent {

    CHRISTMAS_D_DAY(
            "크리스마스 디데이 할인",
            today -> today.between(1, 25)
    ),
    WEEKDAY(
            "평일 할인",
            Today::isWeekday
    ),
    WEEKEND(
            "주말 할인",
            Today::isWeekend
    ),
    SPECIAL(
            "특별 할인",
            today -> today.isChristmas() || today.isSunday()
    );

    private final String eventName;
    private final Function<Today, Boolean> validator;

    DiscountEvent(String eventName, Function<Today, Boolean> validator) {
        this.eventName = eventName;
        this.validator = validator;
    }

    public static List<DiscountEvent> getAvailableEvents(Today today) {
        return Arrays.stream(DiscountEvent.values())
                .filter(discountEvent -> discountEvent.validator.apply(today))
                .toList();
    }

}
