package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.car.CarFixture.createCarAt;
import static racingcar.car.CarFixture.createCarWithDefaultName;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.car.CarSnapshot;
import racingcar.move.MovingStrategy;
import racingcar.move.NumberGenerator;

class RacingGameTest {

    public static final int MOVE = 4;
    public static final int STOP = 3;

    @DisplayName("참가자는 최소 2명이어야 한다")
    @Test
    void 참가자가_2명보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> createRacingGameWithoutRound(List.of(
                createCarWithDefaultName())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한_라운드에서_각_자동차를_이동_조건에_따라_전진시킨다() {
        // given
        RacingGame racingGame = createRacingGameWithNumbers(
                List.of(new Car("pobi"), new Car("jason")),
                MOVE, STOP
        );
        RoundResult expectedResult = round(snapshot("pobi", 1), snapshot("jason", 0));

        // when
        RoundResult roundResult = racingGame.playRound();

        // then
        assertThat(roundResult).isEqualTo(expectedResult);
    }

    @Test
    void 우승자를_찾는다() {
        RacingGame racingGame = createRacingGameWithoutRound(List.of(
                        createCarAt("pobi", 1),
                        createCarAt("jason", 2),
                        createCarAt("woni", 2)
        ));

        assertThat(racingGame.findWinners())
                .as("우승자가 둘이다")
                .hasSize(2)
                .extracting(Car::name)
                .as("우승자는 jason과 woni이다")
                .containsExactlyInAnyOrder("jason", "woni");
    }

    @Test
    void 게임을_진행한다() {
        RacingGame racingGame = createRacingGameWithNumbers(
                List.of(new Car("pobi"), new Car("jason"), new Car("woni")),
                MOVE, MOVE, MOVE,
                MOVE, MOVE, STOP,
                MOVE, STOP, STOP
        );

        GameResult expectedResult = new GameResult(
                List.of(
                        round(snapshot("pobi", 1), snapshot("jason", 1), snapshot("woni", 1)),
                        round(snapshot("pobi", 2), snapshot("jason", 2), snapshot("woni", 1)),
                        round(snapshot("pobi", 3), snapshot("jason", 2), snapshot("woni", 1))
                ),
                List.of("pobi")
        );

        GameResult gameResult = racingGame.play(new RoundCount(3));

        assertThat(gameResult).isEqualTo(expectedResult);
    }

    /**
     * {@link RacingGame#playRound} 가 필요하지 않은 테스트에서 사용한다.
     */
    private static RacingGame createRacingGameWithoutRound(List<Car> cars) {
        return createRacingGameWithNumbers(cars);
    }

    private static RacingGame createRacingGameWithNumbers(List<Car> cars, int... numbers) {
        NumberGenerator numberGenerator = new SequenceNumberGenerator(numbers);
        MovingStrategy movingStrategy = new MovingStrategy(numberGenerator);
        return new RacingGame(cars, movingStrategy);
    }

    private static RoundResult round(CarSnapshot... snapshots) {
        return new RoundResult(Arrays.asList(snapshots));
    }

    private static CarSnapshot snapshot(String name, int position) {
        return new CarSnapshot(name, position);
    }

    private static class SequenceNumberGenerator implements NumberGenerator {

        private final int[] numbers;
        private int index;

        private SequenceNumberGenerator(int... numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers[index++];
        }
    }
}
