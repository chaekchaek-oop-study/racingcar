package racingcar.car;

public class IllegalCarNameException extends IllegalArgumentException {

    public IllegalCarNameException(String message, String currentCarName) {
        super(message + "현재 이름: " + currentCarName);
    }
}
