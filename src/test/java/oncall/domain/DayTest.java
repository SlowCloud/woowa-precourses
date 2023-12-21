package oncall.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {

    @Nested
    class constructor {
        @Test
        void Day를_생성한다() {
            assertDoesNotThrow(() -> new Day(Month.JANUARY, DayOfWeek.FRIDAY));
        }
    }

    @Nested
    class weekday {
        @Test
        void Day가_weekday인지_확인한다() {
            assertAll(
                    () -> assertWeekday(Month.JANUARY, DayOfWeek.MONDAY),
                    () -> assertWeekday(Month.JANUARY, DayOfWeek.TUESDAY),
                    () -> assertWeekday(Month.JANUARY, DayOfWeek.WEDNESDAY)
            );
        }

        @Test
        void Day가_weekend인지_확인한다() {
            assertAll(
                    () -> assertWeekend(Month.JANUARY, DayOfWeek.SATURDAY),
                    () -> assertWeekend(Month.JANUARY, DayOfWeek.SUNDAY)
            );
        }

        private void assertWeekday(Month month, DayOfWeek dayOfWeek) {
            Day day = new Day(month, dayOfWeek);
            assertTrue(day.weekday());
        }

        private void assertWeekend(Month month, DayOfWeek dayOfWeek) {
            Day day = new Day(month, dayOfWeek);
            assertFalse(day.weekday());
        }
    }

    @Nested
    class end {
        @Test
        void Day가_끝인지_확인한다() {
            Day day = new Day(Month.JANUARY, DayOfWeek.MONDAY);
            for (int i = 0; i < Month.JANUARY.maxLength(); i++) {
                day = day.next();
            }
            assertTrue(day.end());
        }

        @Test
        void Day가_끝나지_않았으면_거짓을_반환한다() {
            Day day = new Day(Month.JANUARY, DayOfWeek.MONDAY);
            assertFalse(day.end());
        }
    }

    @Nested
    class next {
        @Test
        void Day의_next를_확인한다() {
            Day day = new Day(Month.JANUARY, DayOfWeek.MONDAY);
            Day nextDay = day.next();
            assertAll(
                    () -> Assertions.assertThat(nextDay).extracting("today").isEqualTo(2),
                    () -> Assertions.assertThat(nextDay).extracting("dayOfWeek").isEqualTo(DayOfWeek.MONDAY.plus(1))
            );
        }
    }

}