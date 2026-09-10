package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 이름 테스트")
class CarNameTest {

    @DisplayName("알파벳으로만 이루어지고, 1자 이상 5자 이하의 이름은 정상 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {
            "A", "Z",
            "a", "z",
            "AAZZZ", "aazzz"
    })
    void 유효한_이름은_정상_생성된다(String validName) {
        assertThatNoException()
                .isThrownBy(() -> new CarName(validName));
    }

    @DisplayName("이름은 null일 수 없다")
    @Test
    void 이름이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(NullPointerException.class);
    }

    @DisplayName("이름 길이는 1자 미만일 수 없다")
    @Test
    void 이름_길이가_1자_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalCarNameException.class);
    }

    @DisplayName("이름 길이는 5자를 초과할 수 없다")
    @Test
    void 이름_길이가_5자를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName("ABCDEF"))
                .isInstanceOf(IllegalCarNameException.class);
    }

    @DisplayName("이름은 영문이 아닌 문자를 포함할 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {
            "A-B",
            "루드비코"
    })
    void 이름이_영문이_아닌_문자를_포함하면_예외가_발생한다(String invalidName) {
        assertThatThrownBy(() -> new CarName(invalidName))
                .isInstanceOf(IllegalCarNameException.class);
    }
}
