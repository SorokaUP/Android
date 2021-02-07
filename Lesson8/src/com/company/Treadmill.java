package com.company;

public class Treadmill implements IBarrier {
    private float val;

    public Treadmill(float val) {
        this.val = val <= 0 ? 1 : val;
    }

    @Override
    public boolean overcome(IGamer gamer) {
        if (gamer instanceof IRunner == false)
        {
            System.out.println("К сожалению " + gamer.getName() + " не умеет бегать, и выбывает из соревнования...");
            return false;
        }

        System.out.println(gamer.getName() + " пробует преодолеть беговую дорожку длинной " + this.val);
        ((IRunner)gamer).run();
        if (((IRunner)gamer).getRunLimit() >= this.val)
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
