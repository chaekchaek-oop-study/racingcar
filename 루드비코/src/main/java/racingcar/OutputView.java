package racingcar;

import java.util.List;
import racingcar.race.RoundResult;

public class OutputView {

    public void printResultHeader() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(RoundResult roundResult) {
        roundResult.snapshots()
                .stream()
                .map(snapshot -> snapshot.name() + " : " + "-".repeat(snapshot.position()))
                .forEach(System.out::println);

        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
