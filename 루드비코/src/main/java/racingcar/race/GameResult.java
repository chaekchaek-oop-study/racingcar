package racingcar.race;

import java.util.List;

public record GameResult(List<RoundResult> rounds, List<String> winners) {

    public GameResult {
        rounds = List.copyOf(rounds);
        winners = List.copyOf(winners);
    }
}
