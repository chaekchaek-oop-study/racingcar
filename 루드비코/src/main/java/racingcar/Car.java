package racingcar;

public class Car {

    private final CarName name;
    private final Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = Position.START;
    }

    // 추가 기능 구현
}
