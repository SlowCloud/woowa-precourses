package oncall.service;

import oncall.constant.DayOfWeekKor;
import oncall.domain.Day;

import java.time.DateTimeException;
import java.time.Month;

public class DayService {
    private static final String DAY_DELIMITER = ",";

    public static Day getDay(String line) {
        String[] split = line.split(DAY_DELIMITER);
        return getDay(split[0].trim(), split[1].trim());
    }

    private static Day getDay(String month, String dayOfWeek) {
        validateNumber(month);
        validateMonth(Integer.parseInt(month));
        return new Day(Month.of(Integer.parseInt(month)), DayOfWeekKor.find(dayOfWeek));
    }

    private static void validateNumber(String month) {
        try {
            Integer.parseInt(month);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateMonth(int month) {
        try {
            Month.of(month);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}