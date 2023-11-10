package christmas.domain;

import christmas.constant.DiscountEvent;

import java.util.List;

public class DiscountEvents {

    private final List<DiscountEvent> discountEvents;

    public DiscountEvents(Today today) {
        this.discountEvents = DiscountEvent.getAvailableEvents(today);
    }

}
