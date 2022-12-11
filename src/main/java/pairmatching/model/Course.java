package pairmatching.model;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static String tmp(String label) {
        return Arrays.stream(values())
                .filter(value -> value.name.equals(label))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .toString();
    }
}