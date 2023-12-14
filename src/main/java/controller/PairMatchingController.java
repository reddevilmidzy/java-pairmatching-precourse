package controller;

import model.Function;
import view.OutputView;

public class PairMatchingController {

    private final InputController inputController;
    private final OutputView outputView;

    public PairMatchingController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {

        Function function = inputController.getFunction();

    }
}
