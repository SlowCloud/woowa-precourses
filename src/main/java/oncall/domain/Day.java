package oncall.domain;

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

    public static Day of(String line) {
        return Converter.getDay(line);
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

    // 서비스로 빼기. 다량의 테스트 필요
    private static class Converter {

        private static final String DAY_DELIMITER = ",";

        public static Day getDay(String line) {
            String[] split = line.split(DAY_DELIMITER);
            return getDay(split[0].trim(), split[1].trim());
        }

        private static Day getDay(String month, String dayOfWeek) {
            validateNumber(month);
            return new Day(Month.of(Integer.parseInt(month)), DayOfWeekKor.find(dayOfWeek));
        }

        private static void validateNumber(String month) {
            try {
                Integer.parseInt(month);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        }

        private enum DayOfWeekKor {
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
        }
    }
}
