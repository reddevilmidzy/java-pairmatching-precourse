package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matching {
    private List<String> crewNames = new ArrayList<>();
    private final Map<String, String> route = new HashMap<>();

    private final List<List<String>> matchedCrew = new ArrayList<>();

    public Matching(String course, String level, String mission) {
        setRoute();
        readFile(course);
        match();
        System.out.println(crewNames.toString());
        System.out.println(matchedCrew);
        // TODO: 크루 겹치면 재배치 기능
    }

    private void readFile(String course) {
        try {
            BufferedReader reader = bufferedReader(course);
            String name;
            while ((name = reader.readLine()) != null) {
                crewNames.add(name);
            }
            crewNames = shuffledCrew(crewNames);
        } catch (IOException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    private void match() {
        if (isEvenCrew()) {
            makeEvenCrew();
            return;
        }
        makeOddCrew();
    }

    private void setRoute() {
        route.put("BACKEND", "src/main/resources/backend-crew.md");
        route.put("FRONTEND", "src/main/resources/frontend-crew.md");
    }

    private BufferedReader bufferedReader(String course) throws FileNotFoundException {
        return new BufferedReader(new FileReader(route.get(Course.getCourse(course))));
    }

    private boolean isEvenCrew() {
        return crewNames.size() % 2 == 0;
    }

    private void makeEvenCrew() {
        for (int i = 0; i < crewNames.size(); i = i + 2) {
            addTwoPair(i);
        }
    }

    private void makeOddCrew() {
        for (int i = 0; i < crewNames.size() - 3; i = i + 2) {
            addTwoPair(i);
        }
        addThreePair(crewNames.size() - 3);
    }

    private void addTwoPair(int index) {
        matchedCrew.add(Arrays.asList(crewNames.get(index), crewNames.get(index + 1)));
    }

    private void addThreePair(int index) {
        matchedCrew.add(Arrays.asList(crewNames.get(index), crewNames.get(index + 1), crewNames.get(index + 2)));
    }

    private List<String> shuffledCrew(List<String> crewNames) {
        return Randoms.shuffle(crewNames);
    }
}