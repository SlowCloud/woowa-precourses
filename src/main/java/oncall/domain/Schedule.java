package oncall.domain;

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

    record Row(Day day, Worker worker) {
    }
}
