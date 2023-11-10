package christmas.domain;

public class Discount {

    private final String message;

    public Discount(String discountMessage, long discount) {
        this.message = String.format(discountMessage + ": -%,l원", discount);
    }

    public String getMessage() {
        return message;
    }

}
