package pairmatching.model;

import java.util.Iterator;
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

    public static Crews of(Course course, String name1, String name2) {
        List<Crew> crews = List.of(new Crew(course, name1), new Crew(course, name2));
        return new Crews(crews);
    }

    public static Crews of(Course course, String name1, String name2, String name3) {
        List<Crew> crews = List.of(new Crew(course, name1), new Crew(course, name2), new Crew(course, name3));
        return new Crews(crews);
    }

    public int size() {
        return crews.size();
    }

    public Iterator<Crew> getIterator() {
        return crews.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Crews target)) {
            return false;
        }
        int count = 0;

        for (Crew matched : target.crews) {
            if (crews.contains(matched)) {
                count++;
            }
        }
        return count > 1;
    }
}
