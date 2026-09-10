package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private final String MOVE_SYMBOL = "-";

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> roundResult) {
        for (Car car : roundResult) {
            System.out.println(car.getName() + " : " + MOVE_SYMBOL.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerName) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerName));
    }
}
