package bridge;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand findByName(String name) {
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.command.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력은 R 또는 Q이어야 합니다!"));
    }
}
