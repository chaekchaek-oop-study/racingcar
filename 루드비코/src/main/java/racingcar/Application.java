package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.move.MovingStrategy;
import racingcar.move.RandomNumberGenerator;
import racingcar.race.GameResult;
import racingcar.race.RacingGame;
import racingcar.race.RoundCount;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<String> carNames = inputView.readCarNames();
        int roundCount = inputView.readRoundCount();

        RacingGame racingGame = new RacingGame(carNames.stream().map(Car::new).toList(),
                new MovingStrategy(new RandomNumberGenerator(0, 9)));
        GameResult gameResult = racingGame.play(new RoundCount(roundCount));

        outputView.printResultHeader();
        gameResult.rounds()
                .forEach(outputView::printRoundResult);
        outputView.printWinners(gameResult.winners());
    }
}
