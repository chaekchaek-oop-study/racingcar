package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.move.MovingStrategy;
import racingcar.move.RandomNumberGenerator;
import racingcar.race.GameResult;
import racingcar.race.RacingGame;
import racingcar.race.RoundCount;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.readCarNames();
        int roundCount = inputView.readRoundCount();
        RacingGame racingGame = new RacingGame(carNames.stream().map(Car::new).toList(),
                new MovingStrategy(new RandomNumberGenerator(0, 9)));
        GameResult gameResult = racingGame.play(new RoundCount(roundCount));

        System.out.println("실행 결과");
        gameResult.rounds()
                .forEach(roundResult -> {
                    roundResult.snapshots()
                            .forEach(snapshot -> {
                                System.out.println(snapshot.name() + " : " + "-".repeat(snapshot.position()));
                            });
                    System.out.println();
                });
        System.out.println("최종 우승자 : " + gameResult.winners().stream().collect(Collectors.joining(", ")));
    }
}
