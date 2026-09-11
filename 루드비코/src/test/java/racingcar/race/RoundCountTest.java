package racingcar.race;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundCountTest {

    @Test
    void 라운드_정상_생성() {
        assertThatNoException()
                .isThrownBy(() -> new RoundCount(1));
    }

    @DisplayName("라운드 수는 1회보다 작을 수 없다")
    @Test
    void 라운드_수가_1회보다_작다면_예외가_발생한다() {
        assertThatThrownBy(() -> new RoundCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}