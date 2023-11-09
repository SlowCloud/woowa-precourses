package christmas.domain;

import christmas.constant.Menu;

public class Order {

    private static final String INVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final Menu menu;
    private final int count;

    public Order(String name, int count) {
        validateMenu(name);
        validateCount(count);
        this.menu = Menu.getMenu(name);
        this.count = count;
    }

    private void validateMenu(String name) {
        if(Menu.getMenu(name) == null) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private void validateCount(int count) {
        if(count <= 0) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

}
