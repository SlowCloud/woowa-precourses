package christmas.service;

import christmas.domain.Today;

public class TodayService {

    public Today createToday(String today) {
        validateNumber(today);
        return new Today(Integer.parseInt(today));
    }

    private void validateNumber(String today) {
        try {
            Integer.parseInt(today);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }

}
