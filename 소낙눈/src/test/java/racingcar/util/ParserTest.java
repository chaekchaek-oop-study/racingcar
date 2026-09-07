package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.util.Parser.parseCarName;
import static racingcar.util.Parser.parseRacingCount;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void 입력한_자동차_이름을_쉼표_기준으로_파싱하여_리스트에_저장한다() {
        // given
        String names = "snow,ao,ruvi";

        // when
        List<String> carNames = parseCarName(names);

        // then
        assertThat(carNames.get(0)).isEqualTo("snow");
        assertThat(carNames.get(1)).isEqualTo("ao");
        assertThat(carNames.get(2)).isEqualTo("ruvi");
    }

    @Test
    void 입력한_경주_횟수를_숫자로_파싱한다() {
        // given
        String count = "5";
        int expectCount = 5;

        // when
        int racingCount = parseRacingCount(count);

        // then
        assertThat(racingCount).isEqualTo(expectCount);
    }
}
