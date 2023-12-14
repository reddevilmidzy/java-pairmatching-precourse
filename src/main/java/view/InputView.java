package view;

import camp.nextstep.edu.missionutils.Console;
import model.Function;

public class InputView {

    public static final String BOUNDARY = "#############################################";

    public String readFunction() {
        System.out.println("기능을 선택하세요.");
        for (Function function : Function.values()) {
            System.out.printf("%s. %s%n", function.getCmd(), function.getValue());
        }
        String value = readLine();
        System.out.println();
        return value;
    }

    public String readMatchingInfo() {
        System.out.println(BOUNDARY);
        //TODO: 하드 코딩 제거
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.printf("미션:%n" +
                "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임%n" +
                "  - 레벨2: 장바구니 | 결제 | 지하철노선도%n" +
                "  - 레벨3: %n" +
                "  - 레벨4: 성능개선 | 배포%n" +
                "  - 레벨5: %n");
        System.out.println(BOUNDARY);

        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String value = readLine();
        System.out.println();
        return value;
    }

    protected String readLine() {
        return Console.readLine();
    }
}