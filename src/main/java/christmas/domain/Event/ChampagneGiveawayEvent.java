package christmas.domain.Event;

import christmas.constant.Menu;
import christmas.domain.Discount.Discount;
import christmas.domain.Giveaway.Giveaway;

public class ChampagneGiveawayEvent implements GiveawayEvent {

    private final Menu champagne = Menu.CHAMPAGNE;
    private final int count = 1;

    public ChampagneGiveawayEvent(int price) {
        validatePrice(price);
    }

    private void validatePrice(int price) {
        if(price < 120_000) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(int price) {
        try {
            return new ChampagneGiveawayEvent(price);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount("증정 이벤트", champagne.getPrice());
    }

    @Override
    public Giveaway getGiveaway() {
        return new Giveaway(champagne.getMenuName(), count);
    }

}
