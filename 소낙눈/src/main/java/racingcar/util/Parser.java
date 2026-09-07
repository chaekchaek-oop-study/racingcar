package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "[ERROR] 자동차 이름은 공백일 수 없습니다.";
    private static final String CAR_NAME_EXCEEDING_FIVE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String RACING_COUNT_BLANK_ERROR_MESSAGE = "[ERROR] 시도 횟수는 공백일 수 없습니다.";
    private static final String RACING_COUNT_IS_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private static final String RACING_COUNT_IS_NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다.";

    public static List<String> parseCarName(String names) {
        validateNameIsNullOrBlank(names);
        List<String> carNames = Arrays.asList(names.split(","));
        validateCarNameIsNullOrBlank(carNames);
        validateCarNameIsLessThanZeroOrExceedingFive(carNames);
        return Arrays.asList(names.split(","));
    }

    public static int parseRacingCount(String count) {
        validateRacingCountIsNullOrBlank(count);
        int racingCount = validateRacingCountIsNumber(count);
        validateRacingCountIsPositive(racingCount);
        return racingCount;
    }

    private static void validateNameIsNullOrBlank(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateCarNameIsNullOrBlank(List<String> carNames) {
        for (String carName : carNames) {
            validateNameIsNullOrBlank(carName);
        }
    }

    private static void validateCarNameIsLessThanZeroOrExceedingFive(List<String> carNames) {
        for (String carName : carNames) {
            validateNameExceedingFive(carName);
        }
    }

    private static void validateNameExceedingFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_EXCEEDING_FIVE_ERROR_MESSAGE);
        }
    }

    private static void validateRacingCountIsNullOrBlank(String racingCount) {
        if (racingCount == null || racingCount.isBlank()) {
            throw new IllegalArgumentException(RACING_COUNT_BLANK_ERROR_MESSAGE);
        }
    }

    private static int validateRacingCountIsNumber(String racingCount) {
        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RACING_COUNT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateRacingCountIsPositive(int racingCount) {
        if (racingCount < 1) {
            throw new IllegalArgumentException(RACING_COUNT_IS_NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
