package racingcar;

public class Car {

    private final CarName name;
    private Position position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = Position.START;
    }

    public void moveForward() {
        position = position.increase();
    }

    public int currentPosition() {
        return position.value();
    }

    public String name() {
        return name.value();
    }
}
