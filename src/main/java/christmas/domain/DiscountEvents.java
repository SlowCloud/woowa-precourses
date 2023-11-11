package christmas.domain;

import christmas.constant.DiscountEvent;

import java.util.List;

public class DiscountEvents {

    private final List<DiscountEvent> discountEvents;

    public DiscountEvents(List<DiscountEvent> discountEvents) {
        this.discountEvents = discountEvents;
    }

    public List<Discount> getDiscounts(Today today, Orders orders) {
        return discountEvents.stream()
                .map(discountEvent -> discountEvent.getDiscount(today, orders))
                .toList();
    }

}
