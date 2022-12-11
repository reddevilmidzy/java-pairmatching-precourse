package pairmatching.model;

public class Feature {
    private String feature;

    public Feature(String feature) {
        this.feature = validate(feature);
    }

    private String validate(String input) {
        return FeatureType.valueOfLabel(input);
    }
}