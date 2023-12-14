package constant;

public enum ErrorMessage {

    INVALID_FUNCTION("유효하지 않은 값입니다."),

    RETRY_INPUT("다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
