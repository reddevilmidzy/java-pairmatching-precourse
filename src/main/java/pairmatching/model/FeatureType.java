package pairmatching.model;

import java.util.Arrays;

public enum FeatureType {
    PAIR_MATCHING("1"),
    PAIR_LOCKUP("2"),
    PAIR_RESET("3"),
    QUIT("Q");

    private String label;

    FeatureType(String label) {
        this.label = label;
    }

    public static FeatureType valueOfLabel(String label) {
        return Arrays.stream(values())
                .filter(value -> value.label.equals(label))
                .findAny()
                .orElse(null);
    }
}