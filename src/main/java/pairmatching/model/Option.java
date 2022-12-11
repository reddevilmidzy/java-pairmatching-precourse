package pairmatching.model;

import java.util.List;

public class Option {
    private static final int OPTION_LENGTH = 3;

    private String course;
    private String level;
    private String mission;

    public Option(List<String> input) {

    }

    private void validate(List<String> input) {
        if (!isValidLength(input)) {
            throw new IllegalArgumentException("과정, 레벨, 미션 총 세가지의 옵션을 선택해주세요.");
        }
        if (!isValidCourse(input)) {
            throw new IllegalArgumentException("해당 과정은 존재하지 않습니다.");
        }
        if (!isValidLevel(input)) {
            throw new IllegalArgumentException("해당 레벨은 존재하지 않습니다.");
        }
    }

    private boolean isValidLength(List<String> input) {
        return input.size() == OPTION_LENGTH;
    }

    private boolean isValidCourse(List<String> input) {
        return Course.valueOfCourse(input.get(0));
    }

    private boolean isValidLevel(List<String> input) {
        return Level.valueOfLevel(input.get(1));
    }
}
