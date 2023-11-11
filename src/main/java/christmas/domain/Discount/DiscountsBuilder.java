package christmas.domain.Discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountsBuilder {

    private final List<Discount> discounts;

    public DiscountsBuilder() {
        discounts = new ArrayList<>();
    }

    public void add(List<Discount> discounts) {
        this.discounts.addAll(discounts);
    }

    public Discounts build() {
        return new Discounts(discounts);
    }

}
