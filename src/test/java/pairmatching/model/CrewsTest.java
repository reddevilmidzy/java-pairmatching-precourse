package pairmatching.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrewsTest {


    @Test
    @DisplayName("두명의 동일한 크루 매칭 확인")
    void createMatching() {
        //given
        Crews crews1 = Crews.of(Course.BACKEND, "동글", "앙마");
        Crews crews2 = Crews.of(Course.BACKEND, "앙마", "동글");

        //when
        boolean equals = crews1.equals(crews2);
        //then
        assertThat(equals).isTrue();
    }

    @Test
    @DisplayName("3 : 2 경우 크루 매칭 확인")
    void create3and2() {
        //given
        Crews crews1 = Crews.of(Course.BACKEND, "동글", "앙마", "커피");
        Crews crews2 = Crews.of(Course.BACKEND, "앙마", "동글");

        //when
        boolean equals = crews1.equals(crews2);
        //then
        assertThat(equals).isTrue();
    }

    @Test
    @DisplayName("동일하지 않은 경우")
    void create2and2() {
        //given
        Crews crews1 = Crews.of(Course.BACKEND, "앙마", "커피");
        Crews crews2 = Crews.of(Course.BACKEND, "앙마", "동글");

        //when
        boolean equals = crews1.equals(crews2);
        //then
        assertThat(equals).isFalse();
    }
}