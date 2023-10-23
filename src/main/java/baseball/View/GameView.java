package baseball.View;

import baseball.Domain.BaseballScore;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

// TODO: inputview랑 outputview 분리
public class GameView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String getNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public void printScore(BaseballScore score) {
        System.out.println(score);
    }

    public void printGameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요.");
    }

    public String getAnswer() {
        return Console.readLine();
    }
}
