package pairmatching.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mission {
    private final Map<Level, List<String>> mission = new HashMap<>();

    public Mission() {
        setMission();
    }

    private void setMission() {
        setLevelOne();
        setLevelTwo();
        setLevelThree();
        setLevelFour();
        setLevelFive();
    }

    public List<String> getMission(Level level) {
        return mission.get(level);
    }

    private void setLevelOne() {
        mission.put(Level.LEVEL1, List.of("자동차경주", "로또", "숫자야구게임"));
    }

    private void setLevelTwo() {
        mission.put(Level.LEVEL2, List.of("장바구니", "결제", "지하철노선도"));
    }

    private void setLevelThree() {
        mission.put(Level.LEVEL3, Collections.emptyList());
    }

    private void setLevelFour() {
        mission.put(Level.LEVEL4, List.of("성능개선", "배포"));
    }

    private void setLevelFive() {
        mission.put(Level.LEVEL5, Collections.emptyList());
    }
}
