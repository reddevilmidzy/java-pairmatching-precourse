package controller;

import model.Course;
import model.Crews;
import model.Function;
import model.Mission;
import service.Matching;
import util.ReadingFile;
import view.OutputView;

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
            Crews crews = Crews.from(course, names);
            Matching matching = new Matching();
            List<List<String>> match = matching.match(names);
        } catch (IOException exception) {
            outputView.printErrorMessage(exception);
        }
    }
}
