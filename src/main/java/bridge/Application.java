package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameController bridgeGameController = new BridgeGameController(inputView, outputView);
        bridgeGameController.play();
    }
}
