package oncall.controller;

import oncall.constant.Calendar;
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
        Schedule schedule = getSchedule(day, weekdayWorkers, weekendWorkers);
        OutputView.printSchedule(schedule);
    }

    private static Schedule getSchedule(Day day, Workers weekdayWorkers, Workers weekendWorkers) {
        Schedule schedule = new Schedule();
        while (!day.end()) {
            Workers workers = getProperWorkers(day, weekdayWorkers, weekendWorkers);
            Worker worker = getProperWorker(workers, schedule);
            schedule.push(day, worker);
            day = day.next();
        }
        return schedule;
    }

    private static Workers getProperWorkers(Day day, Workers weekdayWorkers, Workers weekendWorkers) {
        if (Calendar.dayOff(day)) return weekendWorkers;
        return weekdayWorkers;
    }

    private static Worker getProperWorker(Workers workers, Schedule schedule) {
        Worker worker = pop(workers);
        if (!schedule.empty() && schedule.isContinuous(worker)) {
            worker = getNextWorker(workers, worker);
        }
        return worker;
    }

    private static Worker getNextWorker(Workers workers, Worker worker) {
        Worker nextWorker = pop(workers);
        workers.pushFront(worker);
        worker = nextWorker;
        return worker;
    }

    private static Worker pop(Workers workers) {
        Worker worker = workers.top();
        workers.pop();
        return worker;
    }
}
