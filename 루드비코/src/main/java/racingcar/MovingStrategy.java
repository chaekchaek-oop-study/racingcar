package racingcar;

public class MovingStrategy {

    private static final int MIN_NUMBER_TO_MOVE = 4;

    private final NumberGenerator numberGenerator;

    public MovingStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMove() {
        return numberGenerator.generate() >= MIN_NUMBER_TO_MOVE;
    }
}
