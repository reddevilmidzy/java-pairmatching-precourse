package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Matching;
import pairmatching.view.OutputView;

public class OutputviewTest {
    @DisplayName("")
    @Test
    void printTest () {
        OutputView outputView = new OutputView();
        outputView.printExample();
    }
}
