package com.company;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Tunnel extends Stage {
    private Semaphore smp;
    public Tunnel(Semaphore smp) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.smp = smp;
    }
    @Override
    public void go(Car c, boolean isFinish) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                if (isFinish)
                    c.win();
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}