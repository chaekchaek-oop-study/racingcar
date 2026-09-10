package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import racingcar.move.MovingStrategy;
import racingcar.move.NumberGenerator;

class RacingGameTest {

    @Test
    void 한_라운드에서_각_자동차를_이동_조건에_따라_전진시킨다() {
        // given
        Car pobi = new Car("pobi");
        Car jason = new Car("jason");
        RacingGame racingGame = createRacingGameWithNumbers(List.of(pobi, jason), 4, 3);

        // when
        racingGame.playRound();

        // then
        assertThat(pobi.currentPosition()).isEqualTo(1);
        assertThat(jason.currentPosition()).isZero();
    }

    private static RacingGame createRacingGameWithNumbers(List<Car> cars, int... numbers) {
        NumberGenerator numberGenerator = new SequenceNumberGenerator(numbers);
        MovingStrategy movingStrategy = new MovingStrategy(numberGenerator);
        return new RacingGame(cars, movingStrategy);
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
