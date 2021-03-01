/*
Все участники должны стартовать одновременно, несмотря на разное время подготовки. В тоннель не может одновременно
заехать больше половины участников (условность).

Попробуйте все это синхронизировать.

Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты).
Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).

Когда все завершат гонку, нужно выдать объявление об окончании.

Можно корректировать классы (в том числе конструктор машин) и добавлять объекты классов из пакета java.util.concurrent.
*/

package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        //---------------------------------------------------------------------------
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        CountDownLatch cdlBegin = new CountDownLatch(CARS_COUNT);
        CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT);
        //---------------------------------------------------------------------------
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdlBegin, cdlFinish);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try
        {
            cdlBegin.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        try
        {
            cdlFinish.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
