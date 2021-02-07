package com.company;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие
    действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник
    не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */

public class Main {

    public static void main(String[] args) {
        IGamer[] arrGamers = {
                new Cat("Мурзик", 4f, 20f),
                new Human("Алексей", 0.80f, 130f),
                new Robot("Т900", 2.3f, 48.4f),
                new Robot("Т1000", 7.1f, 2048.4f)
        };

        IBarrier[] arrBarrier = {
                new Treadmill(13f),
                new Treadmill(49f),
                new Wall(0.4f),
                new Treadmill(100f),
                new Wall(2.2f)
        };

        for (IGamer gamer : arrGamers)
        {
            boolean res = false;
            for (IBarrier barrier : arrBarrier) {
                res = barrier.overcome(gamer);
                if (!res)
                {
                    System.out.println(gamer.getName() + " выбывает из соревнования...");
                    break;
                }
            }
            if (res)
                System.out.println(gamer.getName() + " успешно прошел полосу препятствий!");
        }
    }
}