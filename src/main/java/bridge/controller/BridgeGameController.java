package bridge.controller;

import bridge.*;
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
        BridgeGame bridgeGame = new BridgeGame(getBridge());
        while (true) {
            while (!bridgeGame.end()) {
                bridgeGame.move(inputView.readMoving());
                outputView.printMap(bridgeGame.getMap());
            }
            if (!bridgeGame.goal() && inputView.readGameCommand()) {
                bridgeGame.retry(getBridge());
            }
            break;
        }
        outputView.printResult(bridgeGame.getMap());
        outputView.printWinOrNot(bridgeGame.goal());
        outputView.printTryCount(bridgeGame.getTryCount());
    }

    private List<String> getBridge() {
        BridgeLength bridgeLength = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeLength.getLength());
    }
}
