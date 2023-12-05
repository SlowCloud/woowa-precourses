package bridge.controller;

import bridge.*;
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
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while(true) {
            while(!bridgeGame.end()) {
                bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame.getMap());
            }
            if(inputView.retry()) {
                bridgeGame.retry();
            }
        }
        outputView.printResult(bridgeGame.getMap());
        outputView.printWinOrNot(bridgeGame.goal());
        outputView.printTryCount(bridge.getTryCount());
    }

    private Bridge getBridge() {
        BridgeLength bridgeLength = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeLength.getLength()));
    }
}
