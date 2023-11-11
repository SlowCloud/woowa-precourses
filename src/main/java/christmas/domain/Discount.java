package christmas.domain;

public class Discount {

    private final String message;
    private final int discount;

    public Discount(String discountMessage, int discount) {
        this.discount = discount;
        this.message = String.format(discountMessage + ": -%,d원", discount);
    }

    public String getMessage() {
        return message;
    }

    public int getDiscount() {
        return discount;
    }

}
