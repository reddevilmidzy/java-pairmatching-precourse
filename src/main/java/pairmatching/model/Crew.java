package pairmatching.model;

public class Crew {
    private final Course course;
    private final String name;


    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Crew target)) {
            return false;
        }
        return name.equals(target.name);
    }

    @Override
    public String toString() {
        return "course= " + course.getName() + " name = " + name;
    }
}

