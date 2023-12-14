package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingTest {

    @Test
    @DisplayName("짝수 매칭 테스트")
    void createEvenMatching() {
        //given
        Matching matching = new Matching();

        //when
        List<List<String>> match = matching.match(List.of("원투", "쓰리", "포파", "이브"));

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
        List<List<String>> match = matching.match(List.of("원투", "쓰리", "포파", "이브", "식스"));

        //then
        List<String> lastMatching = match.get(match.size() - 1);
        assertThat(lastMatching.size()).isEqualTo(3);
    }
}