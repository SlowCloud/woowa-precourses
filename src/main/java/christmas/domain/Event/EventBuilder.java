package christmas.domain.Event;

import christmas.domain.Order.Orders;
import christmas.domain.Today;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventBuilder {

    private final List<Event> events;

    public EventBuilder() {
        events = new ArrayList<>();
    }

    public EventBuilder buildChristmasDDayEvent(Today today) {
        events.add(ChristmasDDayEvent.createInstance(today));
        return this;
    }

    public EventBuilder buildWeekdayEvent(Today today, Orders orders) {
        events.add(WeekdayEvent.createInstance(today, orders));
        return this;
    }

    public EventBuilder buildWeekendEvent(Today today, Orders orders) {
        events.add(WeekendEvent.createInstance(today, orders));
        return this;
    }

    public EventBuilder buildSpecialEvent(Today today) {
        events.add(SpecialEvent.createInstance(today));
        return this;
    }

    public List<Event> build() {
        return events.stream()
                .filter(Objects::nonNull)
                .toList();
    }

}
