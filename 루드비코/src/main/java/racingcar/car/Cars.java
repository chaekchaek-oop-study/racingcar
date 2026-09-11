package racingcar.car;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Cars {

    private final List<Car> internalList;

    private Cars(List<Car> cars) {
        this.internalList = List.copyOf(cars);
    }

    public static Cars of(Car... cars) {
        return new Cars(Arrays.asList(cars));
    }

    /**
     * 자동차들의 위치 중 최댓값을 반환한다.
     *
     * @return 자동차가 존재하면 위치의 최댓값, 자동차가 없으면 {@link OptionalInt#empty()}
     */
    public OptionalInt findMaxPosition() {
        return internalList.stream()
                .mapToInt(Car::currentPosition)
                .max();
    }

    public List<Car> values() {
        return List.copyOf(internalList);
    }
}
