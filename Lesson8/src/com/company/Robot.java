package com.company;

public class Robot implements IGamer, IRunner, IJumper {
    private String name;
    private float jumpLimit;
    private float runLimit;

    public Robot(String name, float jumpLimit, float runLimit) {
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
        System.out.println(this.name + " включает сервоприводы ног");
    }

    @Override
    public void run() {
        System.out.println(this.name + " rряхтя металлом ускоряется");
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
