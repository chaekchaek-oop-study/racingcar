package racingcar.race;

import java.util.List;
import racingcar.car.CarSnapshot;

public record RoundResult(List<CarSnapshot> snapshots) {

    public RoundResult {
        snapshots = List.copyOf(snapshots);
    }
}
