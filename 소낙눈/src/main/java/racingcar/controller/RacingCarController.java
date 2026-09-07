package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.ForwardDecisionMaker;
import racingcar.service.NumberGenerator;
import racingcar.service.RandomNumberGenerator;
import racingcar.service.WinnerDecisionMaker;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void run() {
        List<String> carNames = parseCarName();
        int racingCount = parseRacingCount();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        OutputView.outputRacingResultMessage();

        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                int randomNumber = randomNumberGenerator.generate();
                if (ForwardDecisionMaker.isForward(randomNumber)) {
                    car.setPosition(car.getPosition() + 1);
                }
            }
            OutputView.outputCurrentRacingStatus(cars);
        }

        List<String> winners = WinnerDecisionMaker.decideWinner(cars);

        OutputView.outputWinner(winners);
    }

    private List<String> parseCarName() {
        String names = InputView.inputCarNames();
        return Parser.parseCarName(names);
    }

    private int parseRacingCount() {
        String count = InputView.inputRacingCount();
        return Parser.parseRacingCount(count);
    }
}
