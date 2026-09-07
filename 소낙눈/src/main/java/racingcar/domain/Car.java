package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameExceedingFive(name);
        validateNameLessThanOne(name);
    }

    private void validateNameExceedingFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateNameLessThanOne(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름은 1글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}