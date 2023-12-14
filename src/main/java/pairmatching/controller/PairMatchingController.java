package pairmatching.controller;

import pairmatching.model.Course;
import pairmatching.model.Crews;
import pairmatching.model.Function;
import pairmatching.model.Mission;
import pairmatching.service.Matching;
import pairmatching.util.ReadingFile;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.List;

public class PairMatchingController {

    private final InputController inputController;
    private final OutputView outputView;

    public PairMatchingController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {

        Function function = inputController.getFunction();
        if (function.equals(Function.MATCHING)) {
            pairMatching();
        }

    }

    private void pairMatching() {
        Mission matchingInfo = inputController.getMatchingInfo();
        Course course = matchingInfo.getCourse();
        try {
            List<String> names = ReadingFile.readCrewNames(course);
            Matching matching = new Matching();
            List<Crews> match = matching.match(course, names);
            outputView.printMatchingResult(match);


        } catch (IOException exception) {
            outputView.printErrorMessage(exception);
        }
    }
}
