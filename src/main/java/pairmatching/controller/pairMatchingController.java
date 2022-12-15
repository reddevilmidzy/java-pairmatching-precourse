package pairmatching.controller;

import pairmatching.model.Feature;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class pairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;

    public pairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.chooseFeature();
        Feature feature = new Feature(input);

    }
}
