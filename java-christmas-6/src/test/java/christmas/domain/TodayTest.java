package christmas.domain;

import christmas.constant.Calender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TodayTest {

    @DisplayName("생성자 테스트")
    @Nested
    class constructor {

        @DisplayName("날짜가 1~31일이 아니면 오류를 반환한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 32, 100})
        void givenNumberIsOutOfRange(int number) {
            Assertions.assertThatThrownBy(() -> new Today(number))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @DisplayName("is 테스트")
    @Nested
    class is {

        @DisplayName("캘린더에 대해 잘 검사하는지 확인한다.")
        @Test
        void checkIs() {
            assertTrue(new Today(25).is(Calender.CHRISTMAS));
        }

    }

    @DisplayName("getToday 테스트")
    @Nested
    class getToday {

        @DisplayName("반환값이 올바른지 확인한다.")
        @Test
        void checkGetToday() {
            assertEquals(new Today(1).getToday(), 1);
        }

    }

}