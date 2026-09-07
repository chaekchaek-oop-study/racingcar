package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class ForwardDecisionMakerTest {

    @Test
    void 난수값이_4_이상일_경우_전진한다() {
        // given
        int forwardNumber = 4;

        // when && then
        assertThat(ForwardDecisionMaker.isForward(forwardNumber)).isTrue();
    }

    @Test
    void 난수값이_4_미만일_경우_전진하지_않는다() {
        // given
        int stopNumber = 3;

        // when && then
        assertThat(ForwardDecisionMaker.isForward(stopNumber)).isFalse();
    }
}
