package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public String chooseFeature() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        return readInput();
    }

    public List<String> chooseOption() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        String input = readInput();
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