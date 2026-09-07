package racingcar.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class WinnerDecisionMaker {

    public static List<String> decideWinner(List<Car> cars) {
        Map<String, Integer> racingResult = new HashMap<>();

        for (Car car : cars) {
            racingResult.put(car.getName(), car.getPosition());
        }

        int max = Collections.max(racingResult.values());

        return racingResult.entrySet().stream()
                .filter(entry -> entry.getValue().equals(max))
                .map(Map.Entry::getKey)
                .toList();
    }
}
