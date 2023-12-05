package bridge.controller;

import bridge.*;
import bridge.domain.BridgeLength;
import bridge.util.ExceptionHandler;

import java.util.List;
import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        BridgeGame bridgeGame = new BridgeGame(getBridge());
        playGame(bridgeGame);
        outputView.printResult(bridgeGame.getMap());
        outputView.printWinOrNot(bridgeGame.goal());
        outputView.printTryCount(bridgeGame.getTryCount());
    }

    private void playGame(BridgeGame bridgeGame) {
        while (true) {
            while (!bridgeGame.end()) {
                bridgeGame.move(repeat(inputView::readMoving));
                outputView.printMap(bridgeGame.getMap());
            }
            if (!bridgeGame.goal() && repeat(inputView::readGameCommand)) {
                bridgeGame.retry(getBridge());
            }
            break;
        }
    }

    private List<String> getBridge() {
        BridgeLength bridgeLength = repeat(inputView::readBridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeLength.getLength());
    }

    private <T> T repeat(Supplier<T> supplier) {
        return ExceptionHandler.repeat(supplier, outputView::printException);
    }
}
