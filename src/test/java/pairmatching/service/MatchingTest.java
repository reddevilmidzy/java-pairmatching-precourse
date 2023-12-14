package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.Crews;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.service.Matching;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingTest {

    @Test
    @DisplayName("짝수 매칭 테스트")
    void createEvenMatching() {
        //given
        Matching matching = new Matching();

        //when
        List<Crews> match = matching.match(Course.FRONTEND, List.of("원투", "쓰리", "포파", "이브"));

        //then
        boolean allMatch = match.stream()
                .allMatch(strings -> strings.size() == 2);
        assertThat(allMatch).isTrue();
    }

    @Test
    @DisplayName("홀수 매칭 테스트")
    void createOddMatching() {
        //given
        Matching matching = new Matching();

        //when
        List<Crews> match = matching.match(Course.BACKEND, List.of("원투", "쓰리", "포파", "이브", "식스"));

        //then
        Crews lastMatching = match.get(match.size() - 1);
        assertThat(lastMatching.size()).isEqualTo(3);
    }
}