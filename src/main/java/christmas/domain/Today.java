package christmas.domain;

import christmas.constant.Calender;
import christmas.constant.ExceptionMessage;

public class Today {

    public static final int START_DATE = 1;
    public static final int LAST_DATE = 31;
    private final int today;

    public Today(int today) {
        validateTodayRange(today);
        this.today = today;
    }

    private void validateTodayRange(int today) {
        if (today < START_DATE || LAST_DATE < today) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TODAY_MESSAGE);
        }
    }

    public boolean between(int from, int to) {
        return from <= today && today <= to;
    }

    public boolean isWeekday() {
        return Calender.WEEKDAY.validate(today);
    }

    public boolean isWeekend() {
        return Calender.WEEKEND.validate(today);
    }

    public boolean isChristmas() {
        return Calender.CHRISTMAS.validate(today);
    }

    public boolean isSunday() {
        return Calender.SUNDAY.validate(today);
    }

    public int getToday() {
        return today;
    }

}
