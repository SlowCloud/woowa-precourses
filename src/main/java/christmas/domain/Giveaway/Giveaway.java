package christmas.domain.Giveaway;

public class Giveaway {

    private final String message;

    public Giveaway(String menuName, int count) {
        this.message = String.format("%s %d개", menuName, count);
    }

    public String getMessage() {
        return message;
    }

}
