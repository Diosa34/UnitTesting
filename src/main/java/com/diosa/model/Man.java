package com.diosa.model;

import java.util.HashMap;

abstract class Man {
    private final String name;
    private Integer confidence = 0;
    private final HashMap<InfluencingType, Integer> confidenceManipulator;

    Man(String name, HashMap<InfluencingType, Integer> confidenceManipulator) {
        this.name = name;
        this.confidenceManipulator = confidenceManipulator;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public String getName() {
        return name;
    }

    public HashMap<InfluencingType, Integer> getConfidenceManipulator() {
        return confidenceManipulator;
    }
}
