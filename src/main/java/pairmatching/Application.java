package pairmatching;

import pairmatching.controller.InputController;
import pairmatching.controller.PairMatchingController;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView, outputView);
        PairMatchingController pairMatchingController = new PairMatchingController(inputController, outputView);
        pairMatchingController.run();

    }
}
