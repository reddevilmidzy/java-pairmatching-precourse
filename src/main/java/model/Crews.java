package model;

import java.util.List;

public class Crews {

    private final List<Crew> crews;

    private Crews(List<Crew> crews) {
        this.crews = crews;
    }

    public static Crews from(Course course, List<String> names) {
        List<Crew> crews = names.stream()
                .map(name -> new Crew(course, name))
                .toList();
        return new Crews(crews);
    }

}
