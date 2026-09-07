package racingcar.domain;

public class Car {
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    private static final String CAR_NAME_EXCEEDING_FIVE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int MAX_CAR_NAME_LENGTH = 5;

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

    private void validateNameLessThanOne(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private void validateNameExceedingFive(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_EXCEEDING_FIVE_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void forward(int position) {
        this.position = position;
    }
}