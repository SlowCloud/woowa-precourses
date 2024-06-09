package oncall.constant;

import java.time.DayOfWeek;
import java.util.Arrays;

public enum DayOfWeekKor {
    월(1), 화(2), 수(3), 목(4), 금(5), 토(6), 일(7);

    private final DayOfWeek dayOfWeek;

    DayOfWeekKor(int number) {
        this.dayOfWeek = DayOfWeek.of(number);
    }

    public static DayOfWeek find(String dayOfWeek) {
        try {
            return valueOf(dayOfWeek).dayOfWeek;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public static DayOfWeekKor findByDayOfWeek(DayOfWeek dayOfWeek) {
        return Arrays.stream(values())
                .filter(dayOfWeekKor -> dayOfWeekKor.dayOfWeek.equals(dayOfWeek))
                .findFirst()
                .orElseThrow();
    }
}
