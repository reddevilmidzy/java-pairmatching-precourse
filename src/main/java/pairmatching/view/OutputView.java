package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String BOUNDARY = "#############################################";
    private static final String SEPARATE_MISSION = "|";
    private static final String COURSE = "과정";
    private static final String LEVEL = "레벨";
    private static final String MISSION = "미션";
    private static final String SEPARATE_CREW = ":";


    public void printCourseMissionLevel(Mission mission) {
        System.out.println(BOUNDARY);
        System.out.printf("%s: %s | %s%n", COURSE, Course.BACKEND, Course.FRONTEND);
        System.out.printf("%s:%n", MISSION);
        System.out.printf("  - %s: %s%n", Level.LEVEL1, formattedMission(mission, Level.LEVEL1));
        System.out.printf("  - %s: %s%n", Level.LEVEL2, formattedMission(mission, Level.LEVEL2));
        System.out.printf("  - %s: %s%n", Level.LEVEL3, formattedMission(mission, Level.LEVEL3));
        System.out.printf("  - %s: %s%n", Level.LEVEL4, formattedMission(mission, Level.LEVEL4));
        System.out.printf("  - %s: %s%n", Level.LEVEL5, formattedMission(mission, Level.LEVEL5));
        System.out.println(BOUNDARY);
    }

    public void printExample() {
        System.out.printf("%s, %s, %s을 선택하세요.%n", COURSE, LEVEL, MISSION);
        System.out.printf("ex) %s, %s, %s", Course.BACKEND, Level.LEVEL1, "자동차경주");
    }

    public void printPair(List<String> pair) {
        System.out.println("페어 매칭 결과입니다.");
        for (int i = 0; i < pair.size(); i = i + 2) {
            System.out.println(String.join(SEPARATE_CREW, Arrays.asList(pair.get(i), pair.get(i+1))));
        }

    }

    private String formattedMission(Mission mission, Level level) {
        List<String> levelOfMission = mission.getMission(level);
        return String.join(SEPARATE_MISSION, levelOfMission);
    }
}
