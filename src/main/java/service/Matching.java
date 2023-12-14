package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Matching {


    public List<List<String>> match(List<String> crewNames) {
        int n = crewNames.size();
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        List<List<String>> result = new ArrayList<>();
        List<String> matched;
        for (int i = 0; i < n - 1; i = i + 2) {
            if (n % 2 == 0 || i != n / 2) {
                matched = List.of(shuffledCrew.get(i), shuffledCrew.get(i + 1));
                result.add(matched);
            } else if (i == n / 2) {
                matched = List.of(shuffledCrew.get(i), shuffledCrew.get(i + 1), shuffledCrew.get(i + 2));
                result.add(matched);
            }
        }
        return result;
    }
}
