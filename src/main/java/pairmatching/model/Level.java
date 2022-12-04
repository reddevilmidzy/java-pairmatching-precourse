package pairmatching.model;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static boolean valueOfLevel(String label) {
        for (Level level : Level.values()) {
            if (level.name.equals(label)) {
                return true;
            }
        }
        return false;
    }
}