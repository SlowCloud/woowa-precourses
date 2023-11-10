package christmas.constant;

import java.util.function.Function;

public enum Calender {

    CHRISTMAS(day -> day == Constants.CHRISTMAS_DAY),
    WEEKDAY(day -> day % 7 == Constants.FRIDAY || day % 7 == Constants.SATURDAY),
    WEEKEND(day -> day % 7 == Constants.SUNDAY || day % 7 == Constants.MONDAY),
    SUNDAY(day -> day % 7 == Constants.SUNDAY);

    private final Function<Integer, Boolean> validator;

    Calender(Function<Integer, Boolean> validator) {
        this.validator = validator;
    }

    public boolean validate(int day) {
        return validator.apply(day);
    }

    private static class Constants {
        public static final int CHRISTMAS_DAY = 25;
        public static final int FRIDAY = 1;
        public static final int SATURDAY = 2;
        public static final int SUNDAY = 3;
        public static final int MONDAY = 4;
    }

}
