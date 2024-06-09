package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    BridgeGame buildBridgeGame(List<String> bridge) {
        return new BridgeGame(bridge);
    }

    @Nested
    class move {
        @DisplayName("move가 잘 작동하는지 확인한다.")
        @Test
        void testMove() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("D");

            Assertions.assertThat(bridgeGame).extracting("moves").isEqualTo(List.of("D"));
        }
    }

    @Nested
    class retry {
        @DisplayName("retry가 잘 작동하는지 확인한다.")
        @Test
        void testRetry() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            List<String> anotherBridge = List.of("U");
            bridgeGame.retry(anotherBridge);

            Assertions.assertThat(bridgeGame).extracting("bridge").isEqualTo(anotherBridge);
        }
    }

    @Nested
    class end {
        @DisplayName("끝까지 경주했을 때, 참을 반환한다.")
        @Test
        void returnTrueWhenGoal() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.move("D");

            assertTrue(bridgeGame.end());
        }

        @DisplayName("길을 틀렸을 때, 참을 반환한다.")
        @Test
        void returnWhenWrongWay() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("U");

            assertTrue(bridgeGame.end());
        }
    }

    @Nested
    class goal {
        @DisplayName("중간에 길을 틀렸다면, 거짓을 반환한다.")
        @Test
        void givenMovesHasWrongMove() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("D");
            bridgeGame.move("U");
            bridgeGame.move("D");

            assertFalse(bridgeGame.goal());
        }

        @DisplayName("틀린 길 없이 끝까지 이동했다면, 참을 반환한다.")
        @Test
        void givenMovesHasALlRightMove() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.move("D");

            assertTrue(bridgeGame.goal());
        }
    }

    @Nested
    class getMap {
        @DisplayName("지도를 잘 만드는지 확인한다.")
        @Test
        void testGetMap() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.move("D");

            Assertions.assertThat(bridgeGame.getMap())
                    .contains(
                            "[ O | O | O ]",
                            "[   |   |   ]"
                    );
        }

        @DisplayName("잘못된 길이 있다면, X를 포함하고 있어야 한다.")
        @Test
        void givenMovesHaveWrongMove() {
            BridgeGame bridgeGame = buildBridgeGame(List.of("D", "D", "D"));

            bridgeGame.move("D");
            bridgeGame.move("U");
            bridgeGame.move("D");

            Assertions.assertThat(bridgeGame.getMap())
                    .contains(" X ");
        }
    }

    @Nested
    class getTryCount {
        @DisplayName("시도 횟수를 잘 구하는지 확인한다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        void testGetTryCount(int count) {
            List<String> bridge = List.of("D", "D", "D");
            BridgeGame bridgeGame = buildBridgeGame(bridge);

            IntStream.range(0, count).forEach(value -> bridgeGame.retry(bridge));

            assertEquals(bridgeGame.getTryCount(), count + 1);
        }
    }
}