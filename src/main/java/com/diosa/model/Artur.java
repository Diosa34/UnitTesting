package com.diosa.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Artur extends Man{
    public Artur(String name, HashMap<InfluencingType, Integer> confidenceManipulator) {
        super(name, confidenceManipulator);
    }

    public void see(ArrayList<InteriorItem> objects) {
        Integer currConf = this.getConfidence();
        for (InteriorItem i : objects) {
            Integer confByType = this.getConfidenceManipulator().get(i.getType());
            currConf += confByType;
        }
        this.setConfidence(currConf);
    }
}
