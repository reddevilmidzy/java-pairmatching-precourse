package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Matching;


public class MatchingTest {
    @DisplayName("백엔드 크루 파일을 불러온다.")
    @Test
    void readBackedCrewFile () {
        Matching matching = new Matching("백엔드", "레벨1", "자동차경주");
    }

    @DisplayName("프론트엔드 크루 파일을 불러온다.")
    @Test
    void readFrontCrewFile () {
        Matching matching = new Matching("프론트엔드", "레벨2", "장바구니");
    }
}
