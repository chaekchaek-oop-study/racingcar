package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> parseCarName(String names) {
        return Arrays.asList(names.split(","));
    }

    public static int parseRacingCount(String count) {
        return Integer.parseInt(count);
    }
}
