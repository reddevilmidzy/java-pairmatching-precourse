package controller;

import model.Function;
import view.InputView;
import view.OutputView;

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
}
