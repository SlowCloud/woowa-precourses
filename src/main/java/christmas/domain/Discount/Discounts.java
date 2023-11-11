package christmas.domain.Discount;

import java.util.ArrayList;
import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts() {
        this.discounts = new ArrayList<>();
    }

    public void add(List<Discount> discounts) {
        this.discounts.addAll(discounts);
    }

    public String getDiscountMessage() {
        List<String> messages = discounts.stream()
                .map(Discount::getMessage)
                .toList();
        return String.join("\n", messages);
    }

    public int getTotalDiscounts() {
        return discounts.stream()
                .mapToInt(Discount::getDiscount)
                .sum();
    }

}
