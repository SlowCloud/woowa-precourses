package christmas.constant;

import java.util.Arrays;
import java.util.function.Function;

public enum Badge {

    NOTHING("없음", discounted -> discounted < 5000),
    STAR("별", discounted -> discounted < 10000),
    TREE("트리", discounted -> discounted < 20000),
    SANTA("산타", discounted -> true);

    private final String badgeName;
    private final Function<Integer, Boolean> validator;

    Badge(String badgeName, Function<Integer, Boolean> validator) {
        this.badgeName = badgeName;
        this.validator = validator;
    }

    public static Badge findBadge(int discounted) {
        return Arrays.stream(values())
                .filter(badge -> badge.validator.apply(discounted))
                .findFirst()
                .orElseThrow();
    }

    public String getBadgeName() {
        return badgeName;
    }

}
