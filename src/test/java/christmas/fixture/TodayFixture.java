package christmas.fixture;

import christmas.domain.Today;

public enum TodayFixture {

    WEEKEND(3),
    WEEKDAY(1),
    SUNDAY(3),
    CHRISTMAS(25),
    BEFORE_CHRISTMAS(1),
    AFTER_CHRISTMAS(26);

    private final int day;

    TodayFixture(int day) {
        this.day = day;
    }

    public Today getToday() {
        return new Today(day);
    }

}
