package racingcar.race;

import java.util.List;
import racingcar.car.Car;
import racingcar.move.MovingStrategy;

public class RacingGame {

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = List.copyOf(cars);
        this.movingStrategy = movingStrategy;
    }

    public void playRound() {
        for (Car car : cars) {
            if (movingStrategy.canMove()) {
                car.moveForward();
            }
        }
    }
}
