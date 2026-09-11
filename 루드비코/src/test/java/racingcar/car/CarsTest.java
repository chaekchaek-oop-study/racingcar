package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차가_없으면_위치의_최댓값도_존재하지_않는다() {
        Cars cars = Cars.of();

        assertThat(cars.findMaxPosition()).isEmpty();
    }

    @Test
    void 자동차들의_위치_중에서_최댓값을_찾는다() {
        Cars cars = Cars.of(
                createCarAt("pobi", 1),
                createCarAt("woni", 2),
                createCarAt("jason", 3)
        );

        assertThat(cars.findMaxPosition().orElseThrow()).isEqualTo(3);
    }

    private static Car createCarAt(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.moveForward();
        }

        return car;
    }
}
