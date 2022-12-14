package pairmatching.model;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static String getCourse(String label) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(label))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .toString();
    }
}