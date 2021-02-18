package com.company;

public abstract class Fruit {
    private float weight;

    public void setWeight(float weight) {
        this.weight = (weight <= 0) ? 0.1f : weight;
    }

    public float getWeight() {
        return weight;
    }
}
