package racingcar.car;

record Position(int value) {

    static final Position START = new Position(0);
    private static final int MOVE_AMOUNT = 1;

    Position {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
    }

    Position increase() {
        return new Position(value + MOVE_AMOUNT);
    }
}
