package com.diosa.model;

import java.util.ArrayList;

public class Environment {
    private final String name;
    private SubstanceState condition;
    private ArrayList<Man> subjects;
    private ArrayList<InteriorItem> objects;

    public Environment(String name, SubstanceState condition, ArrayList<Man> subjects, ArrayList<InteriorItem> objects) {
        this.name = name;
        this.condition = condition;
        this.subjects = subjects;
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public SubstanceState getCondition() {
        return condition;
    }

    public ArrayList<Man> getSubjects() {
        return subjects;
    }

    public ArrayList<InteriorItem> getObjects() {
        return objects;
    }

    public void setCondition(SubstanceState condition) {
        this.condition = condition;
    }
}
