package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @DisplayName("0 이상의 정수를 표현하는 위치는 정상 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void 유효한_위치는_정상_생성된다(int validPosition) {
        assertThatNoException()
                .isThrownBy(() -> new Position(validPosition));
    }

    @DisplayName("위치는 음수일 수 없다")
    @Test
    void 위치가_음수라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진의 단위는 1이다")
    @Test
    void 전진에_성공한다() {
        Position position = new Position(3);

        Position increased = position.increase();

        assertThat(increased).isEqualTo(new Position(4));
    }
}
