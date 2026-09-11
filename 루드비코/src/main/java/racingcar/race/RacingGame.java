package racingcar.race;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.move.MovingStrategy;

public class RacingGame {

    private final Cars cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = Cars.of(cars.toArray(Car[]::new));
        this.movingStrategy = movingStrategy;
    }

    public void playRound() {
        for (Car car : cars.values()) {
            if (movingStrategy.canMove()) {
                car.moveForward();
            }
        }
    }
}
