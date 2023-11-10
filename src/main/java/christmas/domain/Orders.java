package christmas.domain;

import java.util.List;

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public String getOrderedMenusMessage() {
        return String.join("\n", orders.stream().map(Order::getMessage).toList());
    }

}
