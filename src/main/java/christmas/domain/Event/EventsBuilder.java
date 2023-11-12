package christmas.domain.Event;

import christmas.domain.Order.Orders;
import christmas.domain.Today;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EventsBuilder {

    private final List<Event> events;

    public EventsBuilder() {
        events = new ArrayList<>();
    }

    public EventsBuilder buildChristmasDDayEvent(Today today) {
        events.add(ChristmasDDayEvent.createInstance(today));
        return this;
    }

    public EventsBuilder buildWeekdayEvent(Today today, Orders orders) {
        events.add(WeekdayEvent.createInstance(today, orders));
        return this;
    }

    public EventsBuilder buildWeekendEvent(Today today, Orders orders) {
        events.add(WeekendEvent.createInstance(today, orders));
        return this;
    }

    public EventsBuilder buildSpecialEvent(Today today) {
        events.add(SpecialEvent.createInstance(today));
        return this;
    }

    public Events build() {
        return new Events(events.stream()
                .filter(Objects::nonNull)
                .toList());
    }

}
