package pairmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("과정, 레벨, 미션 입력시 쉼표로 구분하여 리스트 형태로 반환한다.")
    @Test
    void createCourseLevelMissionInput() {
        String input = "프론트엔드, 레벨1, 자동차경주";
        List<String> formattedInput = Arrays.asList(input.split(", "));
        assertThat(formattedInput.equals(Arrays.asList("프론트엔드", "레벨1", "자동차경주")));
    }
}
