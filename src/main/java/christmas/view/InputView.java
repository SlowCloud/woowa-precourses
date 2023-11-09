package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Today;

public class InputView {

    public Today getToday() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String number = Console.readLine();
        return Today.of(number);
    }

}
