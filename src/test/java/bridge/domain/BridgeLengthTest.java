package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.rmi.dgc.Lease;

import static org.junit.jupiter.api.Assertions.*;

class BridgeLengthTest {
    @Nested
    class constructor {
        @DisplayName("입력이 3~20 사이가 아니면 오류를 던진다.")
        @ParameterizedTest
        @ValueSource(ints = {0,1,21,100})
        void givenNumberIsOutOfRange(int number) {
            Assertions.assertThatThrownBy(() -> new BridgeLength(number))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class getLength {
        @DisplayName("getLength가 길이를 반환하는지 확인한다.")
        @Test
        void testGetLength() {
            BridgeLength bridgeLength = new BridgeLength(20);
            assertEquals(bridgeLength.getLength(), 20);
        }
    }
}