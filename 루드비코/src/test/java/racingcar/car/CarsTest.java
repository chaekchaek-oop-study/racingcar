package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 자동차가_없으면_위치의_최댓값도_존재하지_않는다() {
        Cars cars = createEmptyCars();

        assertThat(cars.findMaxPosition()).isEmpty();
    }

    @Nested
    class 특정_위치에_있는_자동차들_찾기 {

        @Test
        void 조건을_만족하는_자동차가_있는_경우() {
            Cars cars = Cars.of(
                    createCarAt("pobi", 1),
                    createCarAt("woni", 2),
                    createCarAt("jason", 3)
            );

            assertThat(cars.atPosition(2))
                    .extracting(Car::name)
                    .containsExactly("woni");
        }

        @Test
        void 조건을_만족하는_자동차가_없으면_빈_리스트를_리턴한다() {
            Cars cars = Cars.of(
                    createCarAt("pobi", 1),
                    createCarAt("woni", 2),
                    createCarAt("jason", 3)
            );

            assertThat(cars.atPosition(4))
                    .isEmpty();
        }
    }

    @Nested
    class 자동차들의_위치_중_최댓값_찾기 {

        @Test
        void 최댓값이_존재하는_경우() {
            Cars cars = Cars.of(
                    createCarAt("pobi", 1),
                    createCarAt("woni", 2),
                    createCarAt("jason", 3)
            );

            assertThat(cars.findMaxPosition().orElseThrow()).isEqualTo(3);
        }

        @Test
        void 자동차가_존재하지_않으면_OptionalInt를_리턴한다() {
            Cars cars = createEmptyCars();

            assertThat(cars.findMaxPosition()).isEmpty();
        }
    }

    private static Cars createEmptyCars() {
        return Cars.of();
    }

    private static Car createCarAt(String name, int position) {
        Car car = new Car(name);
        for (int i = 0; i < position; i++) {
            car.moveForward();
        }

        return car;
    }
}
