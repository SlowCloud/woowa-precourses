package christmas.fixture;

import christmas.domain.Order.Order;

public enum OrderFixture {

    MUSHROOM_SOUP("양송이수프", 1),
    DRINK("샴페인", 1),
    OVER_20("양송이수프", 50);

    private final String menuName;
    private final int count;

    OrderFixture(String menuName, int count) {
        this.menuName = menuName;
        this.count = count;
    }

    public Order getOrder() {
        return new Order(menuName, count);
    }

}
