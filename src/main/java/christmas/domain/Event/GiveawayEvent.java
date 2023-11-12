package christmas.domain.Event;

import christmas.domain.Giveaway.Giveaway;

public interface GiveawayEvent extends Event {

    public Giveaway getGiveaway();

}
