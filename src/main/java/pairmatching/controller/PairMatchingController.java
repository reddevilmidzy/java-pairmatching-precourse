package pairmatching.controller;

import pairmatching.constant.ErrorMessage;
import pairmatching.model.Course;
import pairmatching.model.Crews;
import pairmatching.model.Function;
import pairmatching.model.Level;
import pairmatching.model.Mission;
import pairmatching.model.REMATCH;
import pairmatching.repository.MatchingRepository;
import pairmatching.service.Matching;
import pairmatching.util.ReadingFile;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PairMatchingController {

    private final InputController inputController;
    private final OutputView outputView;

    public PairMatchingController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {

        MatchingRepository matchingRepository = new MatchingRepository(createRepository());

        while (true) {
            Function function = inputController.getFunction();
            if (function.equals(Function.MATCHING)) {
                pairMatching(matchingRepository);
            }
            if (function.equals(Function.LOOK_UP)) {
                pairLookUp(matchingRepository);
            }
            if (function.equals(Function.RESET)) {
                pairReset(matchingRepository);
            }
            if (function.equals(Function.QUIT)) {
                break;
            }
        }

    }

    private void pairLookUp(MatchingRepository matchingRepository) {
        Mission matchingInfo = inputController.getMatchingInfo();
        if (matchingRepository.hasMatching(matchingInfo)) {
            List<Crews> matched = matchingRepository.getMatching(matchingInfo);
            outputView.printMatchingResult(matched);
            return;
        }
        //TODO: 여기에서 출력하는거 뭔가 안어울림
        outputView.printErrorMessage(ErrorMessage.NO_MATCHING.getMessage());
    }

    private void pairReset(MatchingRepository matchingRepository) {
        matchingRepository.reset();
        outputView.printReset();
    }

    private HashMap<Level, List<Crews>> createRepository() {
        HashMap<Level, List<Crews>> pre = new HashMap<>();

        for (Level level : Level.values()) {
            pre.put(level, new ArrayList<>());
        }
        return pre;
    }

    private void pairMatching(MatchingRepository matchingRepository) {
        Mission matchingInfo = inputController.getMatchingInfo();
        Course course = matchingInfo.getCourse();
        Matching matching = new Matching();
        try {
            if (matchingRepository.hasMatching(matchingInfo)) {
                REMATCH rematch = inputController.getRematch();
                if (rematch.equals(REMATCH.NO)) {
                    return;
                }
            }
            List<String> names = ReadingFile.readCrewNames(course);
            List<Crews> match = matching.match(course, names);

            boolean matchingSuccess = matchingProcess(matchingRepository, matchingInfo, match);

        } catch (IOException exception) {
            outputView.printErrorMessage(exception);
        }
    }

    private boolean matchingProcess(MatchingRepository matchingRepository, Mission matchingInfo, List<Crews> match) {
        for (int i = 0; i < 3; i++) {
            if (matchingRepository.register(matchingInfo.getLevel(), matchingInfo, match)) {
                outputView.printMatchingResult(match);
                return true;
            }
        }
        return false;
    }
}
