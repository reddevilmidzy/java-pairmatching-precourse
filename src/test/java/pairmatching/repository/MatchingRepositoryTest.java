package pairmatching.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Course;
import pairmatching.model.Crews;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingRepositoryTest {

    @Test
    @DisplayName("이전 레벨에서 매칭된 적 없으면 저장")
    void createPreMatchingFalse() {
        //given
        HashMap<Level, List<Crews>> pre = new HashMap<>();
        Crews value1 = Crews.of(Course.BACKEND, "동글", "앙마");
        Crews value2 = Crews.of(Course.BACKEND, "예지", "리아");
        for (Level level : Level.values()) {
            pre.put(level, new ArrayList<>());
        }
        List<Crews> level1Crew = pre.get(Level.LEVEL1);
        level1Crew.add(value1);
        level1Crew.add(value2);

        MatchingRepository repository = new MatchingRepository(pre);

        //when
        List<Crews> addValue = new ArrayList<>();
        addValue.add(Crews.of(Course.BACKEND, "류진", "채령", "유나"));
        boolean success = repository.register(Level.LEVEL1, Mission.from("백엔드, 레벨1, 자동차경주"), addValue);

        //then
        assertThat(success).isTrue();
    }

    @Test
    @DisplayName("이전 레벨에서 매칭된 적 있으면 저장하지 않음")
    void createPreMatchingTrue() {
        //given
        HashMap<Level, List<Crews>> pre = new HashMap<>();
        Crews value1 = Crews.of(Course.BACKEND, "채령", "유나");
        Crews value2 = Crews.of(Course.BACKEND, "예지", "리아");
        for (Level level : Level.values()) {
            pre.put(level, new ArrayList<>());
        }
        List<Crews> level1Crew = pre.get(Level.LEVEL1);
        level1Crew.add(value1);
        level1Crew.add(value2);

        MatchingRepository repository = new MatchingRepository(pre);

        //when
        List<Crews> addValue = new ArrayList<>();
        addValue.add(Crews.of(Course.BACKEND, "류진", "채령", "유나"));
        boolean success = repository.register(Level.LEVEL1, Mission.from("백엔드, 레벨1, 자동차경주"), addValue);

        //then
        assertThat(success).isFalse();
    }
}