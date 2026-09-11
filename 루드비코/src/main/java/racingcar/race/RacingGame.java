package racingcar.race;

import java.util.List;
import java.util.OptionalInt;
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

    public List<Car> findWinners() {
        OptionalInt maxPosition = cars.findMaxPosition();
        if (maxPosition.isEmpty()) {
            return List.of();
        }

        return cars.atPosition(maxPosition.getAsInt());
    }
}
