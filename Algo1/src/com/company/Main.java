package com.company;

/*
Задание 1.1
Приведите пример алгоритмов и структур данных из жизни.
Задание 1.2
Приведите пример алгоритмов и структур данных в программировании.
Задание 1.3
Напишите программный код, в котором все данные хранятся только в переменных трех типов данных: Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
Выведите написанные данные.
Задание 1.4
Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен имитировать простейший поиск перебором.
Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
 */

import java.util.Arrays;

public class Main {
    private static long currTime;

    public static void main(String[] args) {
        System.out.println("Задание 1.1");
        System.out.println("Пример структур алгоритмов в реальной жизни: Кипячение чайника, звонок по телефону, ремонт проколотого колеса, выкапывание картошки и т.д.");
        System.out.println("Пример структур данных в реальной жизни: документы, их безграничное множество, каждый для своей области.");
        System.out.println("");
        System.out.println("Задание 1.2");
        System.out.println("Самый простой пример алгоритмов, который доступен каждому, это Кипячение воды в чайнике. Выглядит это так:");
        System.out.println("1) Взять чайник");
        System.out.println("2) Открыть кран");
        System.out.println("3) Налить воды");
        System.out.println("4) Проверить уровень");
        System.out.println("5) Выключить воду");
        System.out.println("6) Поставить чайник на плиту");
        System.out.println("7) Включить газ");
        System.out.println("8) Зажечь комфорку");
        System.out.println("9) Ждать кипения воды");
        System.out.println("");
        System.out.println("Пример структур данных в реальной жизни на основе документов: Паспорт, Квитанция ЖКХ, Договор кули-продажи квартиры и т.д.");
        System.out.println("");
        System.out.println("Задание 1.3");
        System.out.println("");
        int verWindows10 = 10;
        String nameGame = "Пасьянс";
        User user = new User("Владислав", 99);
        int[] dayNumbers = { 1, 2, 3, 4, 5, 6, 7 };
        String[] dayNames = { "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье" };
        User[] users = {user,
                new User("Алексей", 69),
                new User("Олег", 96),
                new User("Евкакий", 65)};

        System.out.println("verWindows = " + verWindows10);
        System.out.println("nameGame = " + nameGame);
        System.out.println("user = " + user);
        System.out.println("dayNumbers = " + Arrays.toString(dayNumbers));
        System.out.println("dayNames = " + Arrays.toString(dayNames));
        System.out.println("users = " + Arrays.toString(users));
        System.out.println("");
        System.out.println("Задание 1.4");
        System.out.println("");

        int verWindows7 = 7;
        System.out.println("(verWindows10 == verWindows7) = " + (verWindows10 == verWindows7));
        String nameTopGame = "Dota2";
        System.out.println("(nameTopGame.equals(nameGame)) = " + (nameTopGame.equals(nameGame)));
        System.out.println("(user == users[0]) = " + (user == users[0]));
        System.out.println("(user == users[3]) = " + (user == users[2]));
        System.out.println("(user.equals(users[3])) = " + (user.equals(users[1])));

        timeBegin("Поиск дня недели по номеру 5");
        for (int i = 0; i < dayNumbers.length; i++) {
            if (dayNumbers[i] == 5) {
                System.out.println("  >> его номер в списке: " + i);
                break;
            }
        }
        timeOut("Поиск дня недели по имени Четверг");
        for (int i = 0; i < dayNames.length; i++) {
            if ("Четверг".equals(dayNames[i])) {
                System.out.println("  >> его номер в списке: " + i);
                break;
            }
        }
        timeOut("Поиск Владислава 99 года среди Пользователей");
        for (int i = 0; i < users.length; i++) {
            if (user.equals(users[i])) {
                System.out.println("  >> его номер в списке: " + i);
            }
        }
        timeOut(null);
    }

    public static void timeBegin(String message) {
        System.out.println(message);
        System.out.println("старт...");
        currTime = System.nanoTime();
    }

    public static void timeOut(String message) {
        long currentNanoTime = System.nanoTime();
        System.out.println("всего затрачено времени: " + (currentNanoTime - currTime));
        if (message != null) timeBegin(message);
    }
}
