package christmas.domain;

import christmas.constant.GiveawayEvent;
import christmas.constant.MessageJoiner;
import christmas.domain.Discount.Discount;

import java.util.List;

public class GiveawayEvents {

    public static final String NON_GIVEAWAY_MESSAGE = "없음";
    private final List<GiveawayEvent> giveawayEvents;

    public GiveawayEvents(List<GiveawayEvent> giveawayEvents) {
        this.giveawayEvents = giveawayEvents;
    }

    public String getGiveawayMessage() {
        List<String> messages = giveawayEvents.stream()
                .map(GiveawayEvent::getGiveawayMessage)
                .toList();
        return MessageJoiner.join(messages);
    }

    public List<Discount> getDiscounts() {
        return giveawayEvents.stream()
                .map(GiveawayEvent::getDiscount)
                .toList();
    }

}
