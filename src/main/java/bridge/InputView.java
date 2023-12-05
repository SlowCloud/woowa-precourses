package bridge;

import bridge.domain.BridgeLength;
import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeLength readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return BridgeLength.of(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String move = Console.readLine();
        validateMove(move);
        return move;
    }

    private void validateMove(String move) {
        if(!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 입력은 U 또는 D이어야 합니다!");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        Map<String, Boolean> convert = new HashMap<>();
        convert.put("R", true);
        convert.put("Q", false);
        String command = Console.readLine();
        validateGameCommand(command);
        return convert.get(command);
    }

    private void validateGameCommand(String command) {
        if(!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 입력은 R 또는 Q이어야 합니다!");
        }
    }
}
