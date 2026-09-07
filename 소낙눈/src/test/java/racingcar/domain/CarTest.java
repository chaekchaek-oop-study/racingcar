package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_이름이_5글자를_초과하면_에러가_발생한다() {
        assertThatThrownBy(() -> new Car("snowshower"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차_이름이_공백이면_에러가_발생한다() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void 이름이_5글자_이하_1글자_이상이면_자동차_객체_생성에_성공한다() {
        // given
        String name = "snow";
        Car car = new Car(name);

        // when && then
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 정상_생성된_자동차_객체의_초기_전진_횟수는_0이다() {
        // given
        String name = "snow";
        Car car = new Car(name);

        // when && then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
