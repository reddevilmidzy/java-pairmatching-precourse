package pairmatching.controller;

import pairmatching.view.InputView;

public class PairController {
    private InputView inputView;

    public PairController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        String feature = inputView.chooseFeature();
    }
}
