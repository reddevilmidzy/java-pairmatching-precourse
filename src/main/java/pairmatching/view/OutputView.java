package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.List;

public class OutputView {
    private static final String BOUNDARY = "#############################################";
    private static final String SEPARATE = "|";
    private static final String COURSE = "과정";
    private static final String MISSION = "미션";


    public void printCourseMissionLevel(Mission mission) {
        System.out.println(BOUNDARY);
        System.out.printf("%s: %s | %s", COURSE, Course.BACKEND, Course.FRONTEND);
        System.out.printf("%s:", MISSION);
        System.out.printf("  - %s: %s", Level.LEVEL1, formattedMission(mission, Level.LEVEL1));
        System.out.printf("  - %s: %s", Level.LEVEL2, formattedMission(mission, Level.LEVEL2));
        System.out.printf("  - %s: %s", Level.LEVEL3, formattedMission(mission, Level.LEVEL3));
        System.out.printf("  - %s: %s", Level.LEVEL4, formattedMission(mission, Level.LEVEL4));
        System.out.printf("  - %s: %s", Level.LEVEL5, formattedMission(mission, Level.LEVEL5));
        System.out.println(BOUNDARY);
    }

    private String formattedMission(Mission mission, Level level) {
        List<String> levelOfMission = mission.getMission(level);
        return String.join(SEPARATE, levelOfMission);
    }
}
