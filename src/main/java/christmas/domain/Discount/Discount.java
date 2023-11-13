package christmas.domain.Discount;

import java.util.Objects;

public class Discount {

    private final String message;
    private final int discount;

    public Discount(String discountMessage, int discount) {
        this.discount = -discount;
        this.message = String.format(discountMessage + ": %,d원", -discount);
    }

    public String getMessage() {
        return message;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount1 = (Discount) o;
        return discount == discount1.discount && Objects.equals(message, discount1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, discount);
    }

}
