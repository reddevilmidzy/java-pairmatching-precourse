package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Course;
import pairmatching.model.Crews;

import java.util.ArrayList;
import java.util.List;

public class Matching {


    public List<Crews> match(Course course, List<String> crewNames) {
        int n = crewNames.size();
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        List<Crews> result = new ArrayList<>();
        Crews matched;
        for (int i = 0; i < n - 1; i = i + 2) {
            if (n % 2 == 0 || i != n - 3) {
                matched = Crews.of(course, shuffledCrew.get(i), shuffledCrew.get(i + 1));
                result.add(matched);
            } else if (i == n - 3) {
                matched = Crews.of(course, shuffledCrew.get(i), shuffledCrew.get(i + 1), shuffledCrew.get(i + 2));
                result.add(matched);
            }
        }
        return result;
    }
}
