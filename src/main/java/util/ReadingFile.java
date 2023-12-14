package util;

import model.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadingFile {
    private static final String BE_CREW_ROUTE = "src/main/resources/backend-crew.md";
    private static final String FE_CREW_ROUTE = "src/main/resources/frontend-crew.md";

    private static final Map<Course, String> route;

    static {
        route = new HashMap<>();
        route.put(Course.BACKEND, BE_CREW_ROUTE);
        route.put(Course.FRONTEND, FE_CREW_ROUTE);
    }


    public static List<String> readCrewNames(Course course) throws IOException {
        String crewRoute = route.get(course);
        BufferedReader reader = new BufferedReader(new FileReader(crewRoute));
        List<String> crews = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            crews.add(line);
        }
        reader.close();
        return crews;
    }
}
