package com.company;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
   из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот
   телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона
   по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при
   запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные поля
   (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода
   результатов проверки телефонного справочника.
 */

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        unit1();
        System.out.println("");
        System.out.println("Задание 2");
	    unit2();
    }

    public static void unit1()
    {
        String[] words = { "Apple", "Orange", "Sun", "Apple", "Mango", "Cream", "Sky", "Sky", "More", "Sky", "Magic",
                           "Sun", "Space", "Keyboard", "Desktop", "Book", "Cream", "Sky", "GeekBrains", "Animal" };
        System.out.println(Arrays.toString(words));
        System.out.println("");

        System.out.println("");
        System.out.println("Вариант 1");
        System.out.println("");
        Set res = new TreeSet(); // Выбран TreeSet из-за его возможности сортировки
        for (int i = 0; i < words.length; i++) {
            res.add(words[i]);
        }

        for (Object o : res.toArray())
        {
            String word = o.toString();
            int qnt = 0;
            for (int i = 0; i < words.length; i++) {
                qnt += (word == words[i]) ? 1 : 0;
            }
            System.out.println(word + " = " + qnt);
        }



        System.out.println("");
        System.out.println("Вариант 2");
        System.out.println("");
        Map map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            int qnt = (map.containsKey(words[i])) ? (int)map.get(words[i]) + 1 : 1;
            map.put(words[i], qnt);
        }
        map.forEach((k,v) -> System.out.println(k + " = " + v));
    }

    public static void unit2()
    {
        System.out.println("");
        System.out.println("Вариант 1");
        System.out.println("");

        String[][] arr = {
                {"Сорокин", "+7 (800) 700-80-00"},    // (!)
                {"Васильев", "+7 (800) 700-88-80"},
                {"Ванеев", "+7 (800) 757-68-90"},
                {"Малышев", "+7 (800) 706-78-89"},    // (!!)
                {"Сорокин", "+7 (845) 555-66-78"},    // (!) дубли
                {"Сорокин", "+7 (845) 555-66-78"},    // (!) дубли
                {"Селезнев", "+7 (833) 223-55-67"},
                {"Чернышев", "+7 (800) 767-56-74"},
                {"Малышев", "+7 (800) 704-56-00"},    // (!!)
                {"Авдошин", "+7 (805) 566-78-71"}
        };

        PhoneBook book = new PhoneBook();
        for (int i = 0; i < arr.length; i++) {
            book.add(arr[i][0], arr[i][1]);
        }

        String lastName = "Сорокин";
        ArrayList phones = book.get(lastName);
        if (phones.size() == 0)
        {
            System.out.println("Фамилии " + lastName + " в справочнике не числятся");
        }
        else
        {
            System.out.println("По фамилии " + lastName + " в справочнике числятся следующие номера: ");
            for (int i = 0; i < phones.size(); i++)
            {
                System.out.println(phones.get(i).toString());
            }
        }



        System.out.println("");
        System.out.println("Вариант 2");
        System.out.println("");
        Map map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            mapAdd(map, arr[i][0], arr[i][1]);
        }
        if (!map.containsKey(lastName))
        {
            System.out.println("Фамилии " + lastName + " в справочнике не числятся");
        }
        else
        {
            Set phones2 = (Set)map.get(lastName);
            System.out.println("По фамилии " + lastName + " в справочнике числятся следующие номера: ");
            for (Object item : phones2.toArray())
            {
                System.out.println(item.toString());
            }
        }
    }

    public static void mapAdd(Map map, String lastName, String phone)
    {
        Set phones = (map.containsKey(lastName)) ? (Set)map.get(lastName) : new HashSet();
        phones.add(phone);
        map.put(lastName, phones);
    }
}
