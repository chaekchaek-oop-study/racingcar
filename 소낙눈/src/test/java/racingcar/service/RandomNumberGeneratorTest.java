package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    private final NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    void 난수_생성기는_0에서_9사이의_값만_반환한다() {
        // given
        int number= randomNumberGenerator.generate();

        // when && then
        assertThat(number >= 0 && number <= 9).isTrue();
    }
}
