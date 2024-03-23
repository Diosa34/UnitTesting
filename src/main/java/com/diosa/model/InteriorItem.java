package com.diosa.model;

public class InteriorItem extends Influencing{
    private final String name;
    private final InfluencingType type;

    public InteriorItem(String name, InfluencingType type) {
        super(type);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public InfluencingType getType() {
        return type;
    }
}
