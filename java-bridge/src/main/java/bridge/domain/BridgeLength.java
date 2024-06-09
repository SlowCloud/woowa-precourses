package bridge.domain;

public class BridgeLength {
    public static final int LENGTH_LOWER_BOUND = 3;
    public static final int LENGTH_UPPER_BOUND = 21;
    private final int length;

    public BridgeLength(int length) {
        validateLength(length);
        this.length = length;
    }

    private void validateLength(int length) {
        if (length < LENGTH_LOWER_BOUND || LENGTH_UPPER_BOUND <= length) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static BridgeLength of(String s) {
        validateNumber(s);
        return new BridgeLength(Integer.parseInt(s));
    }

    private static void validateNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다!");
        }
    }

    public int getLength() {
        return length;
    }
}
