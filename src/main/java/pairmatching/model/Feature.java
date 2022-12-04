package pairmatching.model;

public class Feature {
    private String feature;

    public Feature(String feature) {
        validate(feature);
        this.feature = feature;
    }

    private void validate(String input) {
        if (FeatureType.valueOfLabel(input) == null) {
            throw new IllegalArgumentException("잘못된 기능 입력입니다.");
        }
    }
}
