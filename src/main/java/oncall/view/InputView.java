package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.domain.Day;
import oncall.domain.Workers;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static Day getDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        String line = Console.readLine();
        return Day.of(line);
    }

    public static Workers getWeekdayWorkers() {
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요 >");
        return getWorkers();
    }

    public static Workers getWeekendWorkers() {
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요 >");
        return getWorkers();
    }

    private static Workers getWorkers() {
        String line = Console.readLine();
        return new Workers(Arrays.stream(line.split(",")).toList());
    }
}
