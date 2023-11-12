package christmas.domain.Discount;

import christmas.constant.MessageJoiner;

import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public String getDiscountMessage() {
        List<String> messages = discounts.stream()
                .map(Discount::getMessage)
                .toList();
        return MessageJoiner.join(messages);
    }

    public int getTotalDiscounts() {
        return discounts.stream()
                .mapToInt(Discount::getDiscount)
                .sum();
    }

}
