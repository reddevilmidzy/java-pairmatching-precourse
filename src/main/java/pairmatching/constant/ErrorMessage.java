package pairmatching.constant;

public enum ErrorMessage {

    INVALID_FUNCTION("유효하지 않은 기능 명령입니다."),
    INVALID_COURSE("존재하지 않은 과정입니다."),
    INVALID_LEVEL("존재하지 않은 레벨입니다."),
    INVALID_MISSION("존재하지 않은 미션입니다."),
    RETRY_INPUT("다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
