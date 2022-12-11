package pairmatching.model;

public class Feature {
    private String feature;

    public Feature(String feature) {
        validate(feature);
        this.feature = formattedInput(feature);
    }

    private void validate(String input) {
        FeatureType.valueOfLabel(input);
    }

    private String formattedInput(String input) {
        return FeatureType.valueOfLabel(input).toString();
    }
}