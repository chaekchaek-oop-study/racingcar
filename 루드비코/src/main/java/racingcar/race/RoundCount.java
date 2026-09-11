package racingcar.race;

public record RoundCount(int value) {

    private static final int MIN_ROUND_COUNT = 1;

    public RoundCount {
        if (value < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("라운드는 " + MIN_ROUND_COUNT + "회 이상이어야 합니다.");
        }
    }
}
