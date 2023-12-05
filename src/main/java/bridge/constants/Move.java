package bridge.constants;

import java.util.Arrays;

public enum Move {
    UP("U"), DOWN("D");

    private final String name;

    Move(String name) {
        this.name = name;
    }

    public static Move findByName(String name) {
        return Arrays.stream(values())
                .filter(move -> move.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력은 U 또는 D이어야 합니다!"));
    }

    public String getString() {
        return name;
    }
}
