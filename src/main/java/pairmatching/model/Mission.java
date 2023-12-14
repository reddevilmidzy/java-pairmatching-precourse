package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Mission {

    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;

    private final Course course;
    private final Level level;
    private final String name;

    public Mission(Course course, Level level, String name) {
        this.course = course;
        this.level = level;
        this.name = name;
    }

    public static Mission from(String value) {
        validate(value);
        List<String> separateValue = Arrays.stream(value.split(","))
                .map(String::trim)
                .toList();
        Course course = Course.nameOf(separateValue.get(COURSE_INDEX));
        Level level = Level.nameOf(separateValue.get(LEVEL_INDEX));
        String missionName = level.getMission(separateValue.get(MISSION_INDEX));
        return new Mission(course, level, missionName);
    }

    public Course getCourse() {
        return course;
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

    public Level getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mission mission)) {
            return false;
        }
        return course.equals(mission.course) && level.equals(mission.level) && name.equals(mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, name);
    }
}
