package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> moves;
    private List<String> bridge;
    private int tryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        moves = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        moves.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridge) {
        tryCount++;
        moves.clear();
        this.bridge = bridge;
    }

    public boolean end() {
        return goal() || wrongWay();
    }

    private boolean wrongWay() {
        return IntStream.range(0, moves.size())
                .anyMatch(i -> !bridge.get(i).equals(moves.get(i)));
    }

    public boolean goal() {
        return bridge.size() == moves.size();
    }

    public String getMap() {
        String res = "";
        res += "[" + String.join("|", getMapLine("U")) + "]";
        res += "\n";
        res += "[" + String.join("|", getMapLine("D")) + "]";
        return res;
    }

    private List<String> getMapLine(String direction) {
        List<String> line = new ArrayList<>();
        Map<Boolean, String> elements = new HashMap<>();
        elements.put(true, " O ");
        elements.put(false, " X ");
        for (int i = 0; i < moves.size(); i++) {
            String move = moves.get(i);
            if (!move.equals(direction)) {
                line.add("   ");
                continue;
            }
            line.add(elements.get(isCorrectMove(move, i)));
        }
        return line;
    }

    private boolean isCorrectMove(String move, int i) {
        return move.equals(bridge.get(i));
    }

    public int getTryCount() {
        return tryCount;
    }
}
