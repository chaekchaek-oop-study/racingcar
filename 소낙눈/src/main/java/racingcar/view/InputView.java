package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String STARTING_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";

    public static String inputCarNames() {
        System.out.println(STARTING_MESSAGE);
        return Console.readLine();
    }

    public static String inputRacingCount() {
        System.out.println(COUNT_MESSAGE);
        return Console.readLine();
    }
}
