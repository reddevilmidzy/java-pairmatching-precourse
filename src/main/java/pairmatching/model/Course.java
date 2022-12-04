package pairmatching.model;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드", "src/main/resources/backend-crew.md"),
    FRONTEND("프론트엔드", "src/main/resources/frontend-crew.md");

    private String name;
    private String route;

    Course(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public static boolean valueOfCourse(String label) {
        for (Course course : Course.values()) {
            if (course.name.equals(label)) {
                return true;
            }
        }
        return false;
    }

    public static String getRoute(String name) {
        for (Course course : Course.values()) {
            if (course.name.equals(name)) {
                return course.route;
            }
        }
        return null;
    }
}
