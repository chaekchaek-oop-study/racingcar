package racingcar.car;

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

    public boolean isAt(int position) {
        return this.position
                .equals(new Position(position));
    }

    public int currentPosition() {
        return position.value();
    }

    public String name() {
        return name.value();
    }

    public CarSnapshot snapshot() {
        return new CarSnapshot(name(), currentPosition());
    }
}
