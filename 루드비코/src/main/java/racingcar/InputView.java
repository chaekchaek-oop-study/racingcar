package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawNames = Console.readLine();

        return Arrays.stream(rawNames.split(","))
                .map(String::strip)
                .toList();
    }

    public int readRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String rawRoundCount = Console.readLine();

        return Integer.parseInt(rawRoundCount);
    }
}
