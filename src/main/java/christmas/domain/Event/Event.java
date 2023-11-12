package christmas.domain.Event;

import christmas.domain.Discount.Discount;

public interface Event {

    int EVENT_AVAILABLE_PRICE = 10_000;

    public Discount getDiscount();

    public static void validatePrice(int price) {
        if(price < EVENT_AVAILABLE_PRICE) {
            throw new IllegalArgumentException();
        }
    }

}
