package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이름을_가진다() {
        Car car = new Car("jason");

        assertThat(car.name()).isEqualTo("jason");
    }

    @Test
    void 초기_위치는_0이다() {
        Car car = createCarWithDefaultName();

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    void 전진하면_위치가_1_증가한다() {
        Car car = createCarWithDefaultName();
        int beforeMoving = car.currentPosition();

        car.moveForward();

        assertThat(car.currentPosition()).isEqualTo(beforeMoving + 1);
    }

    private static Car createCarWithDefaultName() {
        return new Car("pobi");
    }
}
