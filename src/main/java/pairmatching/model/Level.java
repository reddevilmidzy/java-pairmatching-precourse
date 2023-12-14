package pairmatching.model;

import pairmatching.constant.ErrorMessage;

import java.util.List;

public enum Level {
    LEVEL1("레벨1", List.of("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", List.of("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of("성능개선", "배포")),
    LEVEL5("레벨5", List.of());

    private final String name;
    private final List<String> missions;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

// 추가 기능 구현

    public static Level nameOf(String value) {
        for (Level level : Level.values()) {
            if (level.name.equals(value)) {
                return level;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LEVEL.getMessage());
    }

    public String getMission(String mission) {
        if (this.missions.contains(mission)) {
            return mission;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_MISSION.getMessage());
    }
}
