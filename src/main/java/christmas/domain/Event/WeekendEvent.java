package christmas.domain.Event;

import christmas.constant.Calender;
import christmas.constant.Course;
import christmas.domain.Discount.Discount;
import christmas.domain.Order.Orders;
import christmas.domain.Today;

public class WeekendEvent implements DiscountEvent {

    private static final String EVENT_NAME = "주말 할인";

    private final int dessertCount;

    public WeekendEvent(Today today, Orders orders) {
        Event.validatePrice(orders.getTotalPrice());
        validateToday(today);
        this.dessertCount = orders.getCourseCount(Course.DESSERT);
    }

    private void validateToday(Today today) {
        if (!today.is(Calender.WEEKEND)) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(Today today, Orders orders) {
        try {
            return new WeekendEvent(today, orders);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount(EVENT_NAME, dessertCount * 2023);
    }

}
