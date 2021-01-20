package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        unit1();
        unit2();
    }

    // Задача 1.
    // Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void unit1()
    {
        int z = 0;
        int maxStep = 3;
        int question = 0;

        System.out.println("Задание 1. Компьютер загадал число от 0 до 9 (включительно), отгадайте число, у вас есть 3 попытки.");
        Scanner sc = new Scanner(System.in);
        do
        {
            int step = 1;
            int x = new Random().nextInt(11)-1;
            do
            {
                System.out.print("Введите число: ");
                z = sc.nextInt();

                if (x == z)
                {
                    System.out.println("Поздравляю! Вы угадали!");
                    break;
                }
                else
                {
                    if (step == maxStep)
                    {
                        System.out.println("К сожалению, попытки закончились.");
                        break;
                    }
                    System.out.printf("Ваше число %s. Попыток осталось: %d\n", ((z > x) ? "больше" : "меньше"), (maxStep - step ));
                    step++;
                }
            } while (true);

            System.out.println("Я загадал: " + x);
            System.out.println("Повторить игру еще раз? \"1\" - Да, \"0\" - Нет");
            do
            {
                System.out.print("Ваш ответ: ");
                question = sc.nextInt();
                if (!chkValRange(question,0,1))
                    System.out.println("Введите число в диапозоне 0-1 включительно.");
            }
            while (!chkValRange(question,0,1));

        } while (question == 1);
        System.out.println("Игра окончена.");
        sc.close();
    }

    private static boolean chkValRange(int x, int min, int max)
    {
        return x >= min && x <= max;
    }

    // Задача 2
    // Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
    // "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
    // "pear", "pepper", "pineapple", "pumpkin", "potato"}. При запуске программы компьютер загадывает слово, запрашивает
    // ответ у пользователя, сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
    // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах. apple – загаданное apricot -
    // ответ игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова) Для сравнения двух слов
    // посимвольно можно пользоваться: String str = "apple"; char a = str.charAt(0); - метод, вернет char, который стоит
    // в слове str на первой позиции Играем до тех пор, пока игрок не отгадает слово. Используем только маленькие буквы.
    public static void unit2()
    {
        String[] words = { "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry"
                         , "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut"
                         , "pear", "pepper", "pineapple", "pumpkin", "potato" };
        String x = words[new Random().nextInt(words.length)-1]; // Слово загаданное компьютером
        String s = ""; // Пользовательское слово
        Scanner sc = new Scanner(System.in);

        System.out.println(x);
        System.out.println("Задание 2. Компьютер загадал слово из словаря. Отгадайте его.");
        do
        {
            System.out.print("Ваше слово: ");
            s = sc.nextLine().toLowerCase(Locale.ROOT).trim();
            if (x.equals(s))
            {
                System.out.println("Поздравляю! Вы угадали.");
                break;
            }
            else
            {
                String mask = "";
                for (int i = 0; i < 15; i++) {
                    if (i >= s.length() || i >= x.length())
                    {
                        mask += '#';
                    }
                    else
                    {
                        mask += (s.charAt(i) == x.charAt(i)) ? s.charAt(i) : '#';
                    }
                }
                System.out.println(mask);
            }
        } while (true);

        System.out.println("Конец игры.");
        sc.close();
    }
}
