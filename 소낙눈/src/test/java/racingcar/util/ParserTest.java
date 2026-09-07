package racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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

    @Test
    void 자동차_이름이_공백이거나_null일_경우_에러가_발생한다() {
        // given
        String names1 = "snow, ";

        // when && then
        assertThatThrownBy(() -> parseCarName(names1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백일 수 없습니다.");

        assertThatThrownBy(() -> parseCarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    void 자동차_이름이_5자를_초과할_경우_에러가_발생한다() {
        // given
        String names1 = "snowshower, snow";

        // when && then
        assertThatThrownBy(() -> parseCarName(names1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 경주_횟수가_공백이거나_null일_경우_에러가_발생한다() {
        // given
        String count1 = "";
        String count2 = null;

        // when && then
        assertThatThrownBy(() -> parseRacingCount(count1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 공백일 수 없습니다.");
        assertThatThrownBy(() -> parseRacingCount(count2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 공백일 수 없습니다.");
    }

    @Test
    void 경주_횟수가_숫자가_아닐_경우_에러가_발생한다() {
        // given
        String count = "a";

        // when && then
        assertThatThrownBy(() -> parseRacingCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void 경주_횟수가_양수가_아닐_경우_에러가_발생한다() {
        // given
        String count1 = "0";
        String count2 = "-1";

        // when && then
        assertThatThrownBy(() -> parseRacingCount(count1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 양수여야 합니다.");

        assertThatThrownBy(() -> parseRacingCount(count2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 시도 횟수는 양수여야 합니다.");
    }
}
