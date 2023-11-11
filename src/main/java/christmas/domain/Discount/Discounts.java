package christmas.domain.Discount;

import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public String getDiscountMessage() {

        if(discounts.isEmpty()) {
            return "없음";
        }

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
