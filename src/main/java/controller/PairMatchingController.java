package controller;

import model.Function;
import model.Mission;
import view.OutputView;

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
        Mission matchingInfo = inputController.getMatchingInfo();


    }
}
