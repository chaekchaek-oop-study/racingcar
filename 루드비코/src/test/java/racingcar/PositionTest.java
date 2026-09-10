package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final int START_POSITION = 0;

    private static Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("시작 위치는 0이다")
    void 생성된_자동차의_위치는_초기_위치로_지정된다() {
        assertThat(car.currentPosition()).isEqualTo(START_POSITION);
    }

    @Test
    @DisplayName("위치는 뒤로 이동할 수 없다")
    void 위치를_뒤로_이동하려고_하면_예외가_발생한다() {
        assertThatThrownBy(() -> car.move(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
