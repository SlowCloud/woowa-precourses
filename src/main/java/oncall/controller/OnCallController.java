package oncall.controller;

import oncall.domain.Day;
import oncall.domain.Schedule;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {
    public void play() {
        Day day = InputView.getDay();
        Workers weekdayWorkers = InputView.getWeekdayWorkers();
        Workers weekendWorkers = InputView.getWeekendWorkers();
        Schedule schedule = new Schedule();
        while (!day.end()) {
            Workers workers;
            if (day.weekday()) workers = weekdayWorkers;
            else workers = weekendWorkers;
            Worker worker = workers.top();
            workers.pop();
            if (schedule.isContinous(worker)) {
                Worker nextWorker = workers.top();
                workers.pop();
                workers.pushFront(worker);
                worker = nextWorker;
            }
            schedule.push(day, worker);
            day = day.next();
        }
        OutputView.printSchedule(schedule);
    }
}
