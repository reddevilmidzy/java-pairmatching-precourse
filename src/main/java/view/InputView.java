package view;

import camp.nextstep.edu.missionutils.Console;
import model.Function;

public class InputView {

    public String readFunction() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.printf("%s. %s%n", function.getCmd(), function.getValue());
        }
        String value = readLine();
        System.out.println();
        return value;
    }

    protected String readLine() {
        return Console.readLine();
    }
}