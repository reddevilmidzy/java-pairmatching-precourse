package pairmatching.controller;

import pairmatching.model.Function;
import pairmatching.model.Mission;
import pairmatching.model.REMATCH;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;


    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Function getFunction() {
        while (true) {
            try {
                return readFunction();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Function readFunction() {
        String value = inputView.readFunction();
        return Function.cmdOf(value);
    }

    public Mission getMatchingInfo() {
        while (true) {
            try {
                return readMatchingInfo();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Mission readMatchingInfo() {
        String value = inputView.readMatchingInfo();
        return Mission.from(value);
    }


    public REMATCH getRematch() {
        while (true) {
            try {
                return readRematch();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private REMATCH readRematch() {
        String value = inputView.readRematching();
        return REMATCH.fromCmd(value);
    }

}
