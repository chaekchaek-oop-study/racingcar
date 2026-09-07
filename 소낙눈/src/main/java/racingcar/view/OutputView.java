package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public static void outputRacingResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void outputCurrentRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "- ".repeat(car.getPosition()).trim());
        }
        System.out.println();
    }

    public static void outputWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        String result = String.join(", ", winners);
        System.out.println(result);
    }
}
