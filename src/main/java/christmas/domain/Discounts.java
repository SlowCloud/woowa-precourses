package christmas.domain;

import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    private String getDiscountMessage() {
        List<String> messages = discounts.stream()
                .map(Discount::getMessage)
                .toList();
        return String.join("\n", messages);
    }

}
