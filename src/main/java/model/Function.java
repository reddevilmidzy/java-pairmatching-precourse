package model;

import constant.ErrorMessage;

public enum Function {
    MATCHING("1", "페어 매칭"),
    LOOK_UP("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    QUIT("Q", "종료"),
    ;

    private final String cmd;
    private final String value;


    Function(String cmd, String value) {
        this.cmd = cmd;
        this.value = value;
    }

    public static Function cmdOf(String cmd) {
        for (Function function : Function.values()) {
            if (function.cmd.equals(cmd)) {
                return function;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_FUNCTION.getMessage());
    }

    public String getValue() {
        return value;
    }

    public String getCmd() {
        return cmd;
    }
}
