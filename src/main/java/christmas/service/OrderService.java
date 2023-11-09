package christmas.service;

import christmas.domain.Order;

import java.util.Arrays;
import java.util.List;

public class OrderService {

    public static final String DASH_STRING = "-";
    public static final char DASH_CHAR = '-';
    public static final int DASH_COUNT = 1;
    public static final String INVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요.";

    public List<Order> createOrders(String ordersString) {
        return Arrays.stream(ordersString.split(","))
                .map(this::createOrder)
                .toList();
    }

    public Order createOrder(String orderString) {
        validateDash(orderString);
        String[] splitedString = orderString.split(DASH_STRING);
        return createOrder(splitedString[0].trim(), splitedString[1].trim());
    }

    private void validateDash(String orderString) {
        if (getDashCount(orderString) != DASH_COUNT) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

    private long getDashCount(String orderString) {
        return orderString.chars()
                .filter(value -> value == DASH_CHAR)
                .count();
    }

    private Order createOrder(String menu, String count) {
        validateNumber(count);
        return new Order(menu, Integer.parseInt(count));
    }

    private void validateNumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ORDER_MESSAGE);
        }
    }

}
