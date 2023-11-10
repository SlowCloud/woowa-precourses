package christmas.constant;

import java.util.function.Function;

public enum GiveawayEvent {

    CHAMPAGNE_GIVEAWAY(
            price -> price >= 120_000
    );

    private final Function<Integer, Boolean> validator;

    GiveawayEvent(Function<Integer, Boolean> validator) {
        this.validator = validator;
    }

    public static List<GiveawayEvent> getAvailableEvents(int price) {
        return Arrays.stream(values())
                .filter(giveawayEvent -> giveawayEvent.validator.apply(price))
                .toList();
    }

}
