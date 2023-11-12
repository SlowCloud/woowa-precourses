package christmas.domain.Event;

import christmas.domain.Discount.Discount;

public interface Event {

    public Discount getDiscount();

    public static void validatePrice(int price) {
        if(price < 10_000) {
            throw new IllegalArgumentException();
        }
    }

}
