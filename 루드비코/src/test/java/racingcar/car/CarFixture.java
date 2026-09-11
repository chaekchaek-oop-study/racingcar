package racingcar.car;

public class CarFixture {

    public static Car createCarWithDefaultName() {
        return new Car("pobi");
    }

    public static Cars createEmptyCars() {
        return Cars.of();
    }

    public static Car createCarAt(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.moveForward();
        }

        return car;
    }
}
