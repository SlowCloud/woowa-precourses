package oncall;

import oncall.controller.OnCallController;

public class Application {
    public static void main(String[] args) {
        OnCallController controller = new OnCallController();
        controller.play();
    }
}
