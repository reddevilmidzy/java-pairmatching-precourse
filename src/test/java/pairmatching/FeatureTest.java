package pairmatching;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.model.Feature;

public class FeatureTest {
    @DisplayName("올바르지 못한 입력에 대해 예외를 반환한다.")
    @Test
    void createInValidInput () {
        assertThatThrownBy(() -> new Feature("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}