package com.diosa.model;

public class Fish extends InteriorItem{
    private Integer speed = 0;

    public Fish(String name, InfluencingType type) {
        super(name, type);
    }

    public void swim(Environment env) {
        if (env.getCondition() == SubstanceState.LIQUID) {
            this.speed += 1000;
        } else {
            this.speed = 0;
        }
    }

    public Integer getSpeed() {
        return speed;
    }
}
