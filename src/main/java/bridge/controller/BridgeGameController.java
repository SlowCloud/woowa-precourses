package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.domain.Bridge;
import bridge.domain.BridgeLength;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Bridge bridge = getBridge();

    }

    private Bridge getBridge() {
        BridgeLength bridgeLength = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeLength.getLength()));
    }
}
