package oncall.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    @Nested
    class isContinous {
        @Test
        void 연속_근무자라면_참을_반환한다() {
            Schedule schedule = new Schedule();
            Day day = Mockito.mock(Day.class);
            Worker worker = new Worker("1");

            schedule.push(day, worker);

            assertAll(
                    () -> assertTrue(schedule.isContinous(worker)),
                    () -> assertTrue(schedule.isContinous(new Worker("1")))
            );
        }

        @Test
        void 연속_근무자가_아니라면_거짓을_반환한다() {
            Schedule schedule = new Schedule();
            Day day = Mockito.mock(Day.class);
            Worker worker = new Worker("1");

            schedule.push(day, worker);

            assertFalse(schedule.isContinous(new Worker("2")));
        }
    }

    @Nested
    class push {
        @Test
        void 값을_넣는지_확인() {
            Schedule schedule = new Schedule();
            Day day = Mockito.mock(Day.class);
            Worker worker = new Worker("1");

            schedule.push(day, worker);

            Assertions.assertThat(schedule)
                    .extracting("rows")
                    .isEqualTo(List.of(new Schedule.Row(day, worker)));
        }
    }
}