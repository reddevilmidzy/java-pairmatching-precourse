package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Matching {
    private List<String> crewNames = new ArrayList<>();

    public Matching(String course, String level, String mission) {
        readFile(course);
        System.out.println(crewNames);
    }

    private void readFile(String course) {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(Course.getRoute(course)));
            String name;
            while ((name = reader.readLine()) != null) {
                crewNames.add(name);
            }
            crewNames = shuffledCrew(crewNames);
        } catch (IOException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    private List<String> shuffledCrew(List<String> crewNames) {
        return Randoms.shuffle(crewNames);
    }
}
