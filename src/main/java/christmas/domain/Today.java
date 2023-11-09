package christmas.domain;

public class Today {

    private final int today;

    public Today(int today) {
        validateTodayRange(today);
        this.today = today;
    }

    private void validateTodayRange(int today) {
        if (today < 1 || 31 < today) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static Today of(String today) {
        validateNumber(today);
        return new Today(Integer.parseInt(today));
    }

    private static void validateNumber(String today) {
        try {
            Integer.parseInt(today);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다. 다시 입력해주세요.");
        }
    }

}
