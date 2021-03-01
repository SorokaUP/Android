package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static boolean IS_WIN;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;
    private CountDownLatch cdlBegin;
    private CountDownLatch cdlFinish;
    private Lock lockWinner;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdlBegin, CountDownLatch cdlFinish, Lock lockWinner) {
        this.race = race;
        this.speed = speed;
        this.cb = cb;
        this.cdlBegin = cdlBegin;
        this.cdlFinish = cdlFinish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.IS_WIN = false;
        this.lockWinner = lockWinner;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cdlBegin.countDown();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try
        {
            lockWinner.lock();
            if (!IS_WIN)
            {
                IS_WIN = true;
                System.out.println(this.name + " - WIN");
            }
        }
        finally {
            lockWinner.unlock();
        }
        cdlFinish.countDown();
    }
}