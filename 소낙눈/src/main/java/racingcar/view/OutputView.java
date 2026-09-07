package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static void outputRacingResultMessage() {
        System.out.println("실행 결과");
    }

    public static void outputCurrentRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "- ".repeat(car.getPosition()).trim());
        }
        System.out.println();
    }

    public static void outputWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}
