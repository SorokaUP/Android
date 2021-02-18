package com.company;

/*
        1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        2. Написать метод, который преобразует массив в ArrayList;
        3. Задача:
            * Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
            * Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну
              коробку нельзя сложить и яблоки, и апельсины;
            * Для хранения фруктов внутри коробки можно использовать ArrayList;
            * Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
              вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
            * Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
              подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
              Можно сравнивать коробки с яблоками и апельсинами;
            * Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку
              фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов
              не остается, а в другую перекидываются объекты, которые были в первой;
            * Не забываем про метод добавления фрукта в коробку.
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        unit1();
        unit2();
        unit3();
    }

    public static void unit1()
    {
        Object[] arr = new Object[2];
        arr[0] = new Apple();
        arr[1] = new Orange();

        System.out.println("[0] = "+arr[0].toString()+"   [1] " + arr[1].toString());
        Object o = arr[0];
        arr[0] = arr[1];
        arr[1] = o;
        System.out.println("[0] = "+arr[0].toString()+"   [1] " + arr[1].toString());
    }

    public static void unit2()
    {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        ArrayList<Number> lst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            //if (arr[i] instanceof Integer)
            lst.add(arr[i]);
        }
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i));
        }
    }

    public  static void unit3()
    {
        Box<Apple> boxApple1 = new Box<>();
        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        for (int i = 0; i < 40; i++) {
            boxApple1.addItems(new Apple());
        }
        for (int i = 0; i < 75; i++) {
            boxApple2.addItems(new Apple());
        }
        for (int i = 0; i < 50; i++) {
            boxOrange1.addItems(new Orange());
        }
        for (int i = 0; i < 45; i++) {
            boxOrange2.addItems(new Orange());
        }

        if (boxApple1.compare(boxApple2))
        {
            System.out.println("Коробки по весу равны");
        }
        if (boxApple1.compare(boxOrange1))
        {
            System.out.println("Коробки по весу равны");
        }

        boolean resMoveApple = boxApple2.addFromBox(boxApple1);
        boolean resMoveOrange = boxOrange2.addFromBox(boxOrange1);
    }
}
