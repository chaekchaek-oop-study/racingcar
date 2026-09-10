package racingcar.car;

import java.util.Objects;

record CarName(String value) {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    CarName {
        Objects.requireNonNull(value, "이름이 null입니다.");
        validateLength(value);
        validateOnlyAlphabetic(value);
    }

    private static void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalCarNameException("이름은 " + MIN_LENGTH + "자 이상, " + MAX_LENGTH + "자 이하여야 합니다.", name);
        }
    }

    private static void validateOnlyAlphabetic(String name) {
        for (char c : name.toCharArray()) {
            if (!isAlphabet(c)) {
                throw new IllegalCarNameException("이름은 알파벳만 포함해야 합니다.", name);
            }
        }
    }

    private static boolean isAlphabet(char c) {
        return (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z');
    }
}
