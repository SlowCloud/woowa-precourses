package oncall.domain;

public record Worker(String name) {
    public Worker {
        validateName(name);
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
