package com.company;

public class Wall implements IBarrier {
    private float val;

    public Wall(float val) {
        this.val = val <= 0 ? 1 : val;
    }

    @Override
    public boolean overcome(IGamer gamer) {
        if (gamer instanceof IJumper == false)
        {
            System.out.println("К сожалению " + gamer.getName() + " не умеет прыгать, и выбывает из соревнования...");
            return false;
        }

        System.out.println(gamer.getName() + " пробует преодолеть стену высотой " + this.val);
        ((IJumper)gamer).jump();
        if (((IJumper)gamer).getJumpLimit() >= this.val)
        {
            System.out.println(gamer.getName() + " успешно справился!");
            return true;
        }
        else
        {
            System.out.println(gamer.getName() + " не повезло...");
            return false;
        }
    }
}