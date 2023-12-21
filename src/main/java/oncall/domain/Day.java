package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Day {
    private final DayOfWeek dayOfWeek;
    private Month month;
    private int today;

    public Day(Month month, DayOfWeek dayOfWeek) {
        this(month, dayOfWeek, 1);
    }

    private Day(Month month,  DayOfWeek dayOfWeek, int today) {
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
}
