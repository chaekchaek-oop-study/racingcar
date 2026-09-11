package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.move.MovingStrategy;
import racingcar.move.RandomNumberGenerator;
import racingcar.race.GameResult;
import racingcar.race.RacingGame;
import racingcar.race.RoundCount;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String names = Console.readLine();
        String round = Console.readLine();
        RacingGame racingGame = new RacingGame(Arrays.stream(names.split(",")).map(Car::new).toList(),
                new MovingStrategy(new RandomNumberGenerator(0, 9)));
        GameResult gameResult = racingGame.play(new RoundCount(Integer.parseInt(round)));

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
