package com.diosa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.diosa.model.SubstanceState.GASEOUS;

public class Ford extends Man{
    public Ford(String name, HashMap<InfluencingType, Integer> confidenceManipulator) {
        super(name, confidenceManipulator);
    }

    public void hold(ArrayList<InteriorItem> objects) {
        Integer confByType = 0;
        for (InteriorItem i : objects) {
            confByType += this.getConfidenceManipulator().get(i.getType());
        }
        this.setConfidence(confByType);
    }

    public Integer moveFishToEar(Fish fish) {
        Environment ear = new Environment("ухо", GASEOUS, null, new ArrayList<>(List.of(fish)));
        fish.swim(ear);
        return fish.getSpeed();
    }
}
