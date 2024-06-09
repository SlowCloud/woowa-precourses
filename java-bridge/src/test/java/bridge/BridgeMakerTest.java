package bridge;

import bridge.fixture.FakeBridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @Nested
    class makeBridge {
        @DisplayName("길이에 맞게 의도대로 다리가 잘 생성되는지 확인한다.")
        @Test
        void testMakeBridge() {
            BridgeMaker bridgeMaker =new BridgeMaker(new FakeBridgeNumberGenerator());
            List<String> bridge=  bridgeMaker.makeBridge(10);
            assertAll(
                    () -> assertEquals(bridge.size(), 10),
                    () -> Assertions.assertThat(bridge).allMatch(s -> s.equals("D"))
            );
        }
    }
}

