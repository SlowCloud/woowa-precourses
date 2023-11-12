package christmas.domain.Event;

import christmas.constant.Calender;
import christmas.domain.Discount.Discount;
import christmas.domain.Today;

public class ChristmasDDayEvent implements Event {

    private static final String EVENT_NAME = "크리스마스 디데이 할인";
    private static final int D_DAY_DISCOUNT_BASE = 1000;
    private static final int DISCOUNT_PER_DAY = 100;
    private final int today;

    public ChristmasDDayEvent(Today today) {
        validateToday(today);
        this.today = today.getToday();
    }

    private void validateToday(Today today) {
        if (!today.is(Calender.BEFORE_CHRISTMAS)) {
            throw new IllegalArgumentException();
        }
    }

    public static Event createInstance(Today today) {
        try {
            return new ChristmasDDayEvent(today);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public Discount getDiscount() {
        return new Discount(EVENT_NAME, D_DAY_DISCOUNT_BASE + (today - 1) * DISCOUNT_PER_DAY);
    }

}
