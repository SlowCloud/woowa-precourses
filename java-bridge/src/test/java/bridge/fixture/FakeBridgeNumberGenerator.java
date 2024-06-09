package bridge.fixture;

import bridge.BridgeNumberGenerator;

public class FakeBridgeNumberGenerator implements BridgeNumberGenerator {
    @Override
    public int generate() {
        return 0;
    }
}
