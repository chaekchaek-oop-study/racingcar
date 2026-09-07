package racingcar.service;

public class ForwardDecisionMaker {
    private static final int FORWARD_DECISION_NUMBER = 4;

    public static boolean isForward(int number) {
        return number >= FORWARD_DECISION_NUMBER;
    }
}
