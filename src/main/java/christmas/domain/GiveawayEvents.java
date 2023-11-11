package christmas.domain;

import christmas.constant.GiveawayEvent;

import java.util.List;
import java.util.stream.Stream;

public class GiveawayEvents {

    public static final String NON_GIVEAWAY_MESSAGE = "없음";
    private final List<GiveawayEvent> giveawayEvents;

    public GiveawayEvents(List<GiveawayEvent> giveawayEvents) {
        this.giveawayEvents = giveawayEvents;
    }

    public String getGiveawayMessage() {

        if (giveawayEvents.isEmpty()) {
            return NON_GIVEAWAY_MESSAGE;
        }

        List<String> messages = giveawayEvents.stream()
                .map(GiveawayEvent::getGiveawayMessage)
                .toList();

        return String.join("\n", messages);

    }

    public List<Discount> getDiscounts() {
        return giveawayEvents.stream()
                .map(GiveawayEvent::getDiscount)
                .toList();
    }

}
