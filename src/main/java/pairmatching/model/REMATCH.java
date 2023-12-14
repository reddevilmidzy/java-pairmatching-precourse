package pairmatching.model;

import pairmatching.constant.ErrorMessage;

public enum REMATCH {
    YES("네"),
    NO("아니오"),
    ;

    private final String cmd;

    REMATCH(String cmd) {
        this.cmd = cmd;
    }

    public static REMATCH fromCmd(String value) {
        for (REMATCH rematch : REMATCH.values()) {
            if (rematch.cmd.equals(value)) {
                return rematch;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_REMATCHING.getMessage());
    }
}
