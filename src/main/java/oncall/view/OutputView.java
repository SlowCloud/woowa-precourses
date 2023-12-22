package oncall.view;

import oncall.domain.Schedule;

public class OutputView {
    public static void printSchedule(Schedule schedule) {
        System.out.println(schedule.getMessage());
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
