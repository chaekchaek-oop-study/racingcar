package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MovingStrategyTest {

    @Test
    void 숫자가_4_이상이면_전진할_수_있다() {
        NumberGenerator numberGenerator = () -> 4;
        MovingStrategy movingStrategy = new MovingStrategy(numberGenerator);

        assertThat(movingStrategy.canMove()).isTrue();
    }

    @Test
    void 숫자가_4_미만이면_전진할_수_없다() {
        NumberGenerator numberGenerator = () -> 3;
        MovingStrategy movingStrategy = new MovingStrategy(numberGenerator);

        assertThat(movingStrategy.canMove()).isFalse();
    }
}
