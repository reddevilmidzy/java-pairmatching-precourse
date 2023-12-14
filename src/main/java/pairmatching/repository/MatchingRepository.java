package pairmatching.repository;

import pairmatching.model.Crews;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingRepository {

    private Map<Level, List<Crews>> repository;
    private Map<Mission, List<Crews>> missionRepository;

    public MatchingRepository(Map<Level, List<Crews>> repository) {
        this.repository = repository;
        missionRepository = new HashMap<>();
    }

    public boolean register(Level level, Mission mission, List<Crews> addCrews) {
        List<Crews> crews = repository.get(level);
        for (Crews addCrew : addCrews) {
            if (crews.contains(addCrew)) {
                return false;
            }
        }
        crews.addAll(addCrews);
        missionRepository.put(mission, addCrews);
        return true;
    }

    public boolean hasMatching(Mission mission) {
        return missionRepository.containsKey(mission);
    }

    public void reset() {
        for (Level level : repository.keySet()) {
            List<Crews> crews = repository.get(level);
            crews.clear();
        }
        missionRepository.clear();
    }
}
