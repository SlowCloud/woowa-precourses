package oncall.constant;

import oncall.domain.Day;

import java.time.Month;
import java.util.Arrays;

public enum Calendar {
    신정(1, 1),
    삼일절(3, 1),
    어린이날(5, 5),
    현충일(6, 6),
    광복절(8, 15),
    개천절(10, 3),
    한글날(10, 9),
    성탄절(12, 25);

    private final int month;
    private final int day;

    Calendar(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean dayOff(Day day) {
        return !day.weekday() || Arrays.stream(values()).anyMatch(calendar -> calendar.is(day));
    }

    private boolean is(Day day) {
        return day.is(this.month, this.day);
    }
}
