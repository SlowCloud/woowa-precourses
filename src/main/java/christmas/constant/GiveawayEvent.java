package christmas.constant;

import christmas.domain.Discount;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum GiveawayEvent {

    CHAMPAGNE_GIVEAWAY(
            price -> price >= 120_000,
            Menu.CHAMPAGNE,
            1
    );

    public static final String GIVEAWAY_DISCOUNT_MESSAGE = "증정 이벤트";
    public static final String GIVEAWAY_MESSAGE_TEMPLATE = "%s %d개";
    private final Function<Integer, Boolean> validator;
    private final Menu menu;
    private final int count;

    GiveawayEvent(Function<Integer, Boolean> validator, Menu menu, int count) {
        this.validator = validator;
        this.menu = menu;
        this.count = count;
    }

    public static List<GiveawayEvent> getAvailableEvents(int price) {
        return Arrays.stream(values())
                .filter(giveawayEvent -> giveawayEvent.validator.apply(price))
                .toList();
    }

    public String getGiveawayMessage() {
        return String.format(GIVEAWAY_MESSAGE_TEMPLATE, menu.getMenuName(), count);
    }

    public Discount getDiscount() {
        return new Discount(GIVEAWAY_DISCOUNT_MESSAGE, menu.getPrice());
    }

}
