package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class WinnerDecisionMakerTest {

    @Test
    void 최종_우승자가_한_명일_경우_해당_우승자의_이름을_반환한다() {
        // given
        Car car1 = new Car("snow");
        Car car2 = new Car("ao");
        Car car3 = new Car("ruvi");
        car1.setPosition(5);
        car2.setPosition(3);
        car3.setPosition(3);

        List<Car> cars = List.of(car1, car2, car3);
        String winner = "snow";

        // when && then
        assertThat(WinnerDecisionMaker.decideWinner(cars).get(0)).isEqualTo(winner);
    }

    @Test
    void 최종_우승자가_여러_명일_경우_해당_우승자들의_이름을_반환한다() {
        // given
        Car car1 = new Car("snow");
        Car car2 = new Car("ao");
        Car car3 = new Car("ruvi");
        car1.setPosition(5);
        car2.setPosition(5);
        car3.setPosition(3);

        List<Car> cars = List.of(car1, car2, car3);
        List<String> winners = List.of("snow", "ao");

        // when && then
        assertThat(WinnerDecisionMaker.decideWinner(cars)).isEqualTo(winners);
    }
}
