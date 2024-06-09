package oncall.domain;

import oncall.constant.DayOfWeekKor;

import java.time.DayOfWeek;
import java.time.Month;

public class Day {
    private final DayOfWeek dayOfWeek;
    private final Month month;
    private final int today;

    public Day(Month month, DayOfWeek dayOfWeek) {
        this(month, dayOfWeek, 1);
    }

    private Day(Month month, DayOfWeek dayOfWeek, int today) {
        this.dayOfWeek = dayOfWeek;
        this.month = month;
        this.today = today;
    }

    public boolean end() {
        return today > month.maxLength();
    }

    public boolean weekday() {
        return !(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY));
    }

    public Day next() {
        return new Day(month, dayOfWeek.plus(1), today + 1);
    }

    public boolean is(int month, int day) {
        return Month.of(month).equals(this.month) && this.today == day;
    }

    public String getMessage() {
        return String.format("%d월 %d일 %s", month.getValue(), today, DayOfWeekKor.findByDayOfWeek(dayOfWeek).name());
    }
}
