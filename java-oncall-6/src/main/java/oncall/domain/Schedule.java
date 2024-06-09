package oncall.domain;

import oncall.constant.Calendar;

import java.util.LinkedList;
import java.util.List;

public class Schedule {
    private final List<Row> rows;

    public Schedule() {
        rows = new LinkedList<>();
    }

    public boolean isContinuous(Worker worker) {
        return rows.get(rows.size() - 1).worker().equals(worker);
    }

    public void push(Day day, Worker worker) {
        rows.add(new Row(day, worker));
    }

    public boolean empty() {
        return rows.isEmpty();
    }

    public String getMessage() {
        return String.join(System.lineSeparator(), rows.stream().map(Row::getMessage).toList());
    }

    record Row(Day day, Worker worker) {
        public String getMessage() {
            String message = day.getMessage();
            if (day.weekday() && Calendar.dayOff(day)) message += "(휴일)";
            message += " " + worker().name();
            return message;
        }
    }
}
