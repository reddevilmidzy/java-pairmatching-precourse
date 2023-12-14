package model;

import java.util.Arrays;
import java.util.List;

public class Mission {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final Course course;
    private final Level level;

    public Mission(Course course, Level level) {
        this.course = course;
        this.level = level;
    }

    public static Mission from(String value) {
        validate(value);
        List<String> separateValue = Arrays.stream(value.split(","))
                .map(String::trim)
                .toList();
        Course course = Course.nameOf(separateValue.get(COURSE_INDEX));
        Level level = Level.nameOf(separateValue.get(LEVEL_INDEX));
        String missionName = level.getMission(separateValue.get(MISSION_INDEX));
        return new Mission(course, level);
    }

    private static void validate(String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (value.startsWith(",") || value.endsWith(",")) {
            throw new IllegalArgumentException();
        }
        if (value.contains(",,")) {
            throw new IllegalArgumentException();
        }
    }
}
