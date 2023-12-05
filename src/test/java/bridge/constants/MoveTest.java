package bridge.constants;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MoveTest {
    @Nested
    class findByName {
        @DisplayName("없는 이름을 제시하면 오류를 던진다.")
        @Test
        void givenNameIsNotExist() {
            Assertions.assertThatThrownBy(() -> Move.findByName("없음!!"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("올바른 이름을 제시하면 통과한다.")
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        void givenNameIsExist(String move) {
            assertDoesNotThrow(() -> Move.findByName(move));
        }
    }
}