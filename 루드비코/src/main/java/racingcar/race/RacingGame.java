package racingcar.race;

import java.util.List;
import java.util.OptionalInt;
import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.move.MovingStrategy;

public class RacingGame {

    private static final int MIN_PARTICIPANT_SIZE = 2;

    private final Cars cars;
    private final MovingStrategy movingStrategy;

    public RacingGame(List<Car> cars, MovingStrategy movingStrategy) {
        if (cars.size() < MIN_PARTICIPANT_SIZE) {
            throw new IllegalArgumentException("게임 참가자는 최소 " + MIN_PARTICIPANT_SIZE + "명이어야 합니다.");
        }
        this.cars = Cars.of(cars.toArray(Car[]::new));
        this.movingStrategy = movingStrategy;
    }

    public List<Car> findWinners() {
        OptionalInt maxPosition = cars.findMaxPosition();
        if (maxPosition.isEmpty()) {
            return List.of();
        }

        return cars.atPosition(maxPosition.getAsInt());
    }

    void playRound() {
        for (Car car : cars.values()) {
            if (movingStrategy.canMove()) {
                car.moveForward();
            }
        }
    }
}
