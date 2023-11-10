package christmas.constant;

import christmas.domain.Discount;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum GiveawayEvent {

    CHAMPAGNE_GIVEAWAY(
            price -> price >= 120_000,
            Menu.CHAMPAGNE
    );

    public static final String GIVEAWAY_DISCOUNT_MESSAGE = "증정 이벤트";
    private final Function<Integer, Boolean> validator;
    private final Menu menu;

    GiveawayEvent(Function<Integer, Boolean> validator, Menu menu) {
        this.validator = validator;
        this.menu = menu;
    }

    public static List<GiveawayEvent> getAvailableEvents(int price) {
        return Arrays.stream(values())
                .filter(giveawayEvent -> giveawayEvent.validator.apply(price))
                .toList();
    }

    public Discount getDiscount() {
        return new Discount(GIVEAWAY_DISCOUNT_MESSAGE, menu.getPrice());
    }

}
