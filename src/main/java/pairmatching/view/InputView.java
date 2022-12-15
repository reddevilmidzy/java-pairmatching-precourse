package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String SPACE = " ";
    private static final String REMOVE_WORD = "";

    public String chooseFeature() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        return readInput();
    }

    public List<String> chooseOption() {
        String input = readInput();
        input  = input.replace(SPACE, REMOVE_WORD);
        return Arrays.asList(input.split(","));
    }

    public String chooseRematch() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        return readInput();
    }

    private String readInput() {
        return  Console.readLine();
    }
}