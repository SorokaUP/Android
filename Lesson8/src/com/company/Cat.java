package com.company;

public class Cat implements IGamer, IRunner, IJumper {
    private String name;
    private float jumpLimit;
    private float runLimit;

    public Cat(String name, float jumpLimit, float runLimit) {
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
        System.out.println(this.name + " взмывает в небо");
    }

    @Override
    public void run() {
        System.out.println(this.name + " тыгыдык-тыгыдык");
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
