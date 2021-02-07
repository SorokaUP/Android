package com.company;

public class Human implements IGamer, IRunner, IJumper {
    private String name;
    private float jumpLimit;
    private float runLimit;

    public Human(String name, float jumpLimit, float runLimit) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void jump() {
        System.out.println(this.name + " прыгает");
    }

    @Override
    public void run() {
        System.out.println(this.name + " бежит");
    }

    @Override
    public float getJumpLimit() {
        return this.jumpLimit;
    }

    @Override
    public float getRunLimit() {
        return this.runLimit;
    }
}
