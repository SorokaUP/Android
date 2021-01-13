package com.company;

public class Main {

    public static void main(String[] args) {
        unit2();
        float res3 = unit3(1,2,3,4);
        boolean res4 = unit4(1,2);
        unit5(1);
        boolean res6 = unit6(1);
        unit7("Владислав");
        unit8(1776);
    }

    public static void unit2()
    {
        byte byteVar = 127;
        short shortVar = 32767;
        int intVar = 2147483647;
        long longVar = 9223372036854775807L;
        float floatVar = 3.4e+38f;
        double doubleVar = 1.7e+308;
        boolean booleanVar = true;
        char charVar = 'x';
        String stringVar = "variable";
    }

    public static float unit3(float a, float b, float c, float d)
    {
        return a*(b+(c/d));
    }

    public static boolean unit4(int a, int b)
    {
        int summ = a+b;
        return (summ >= 10 || summ <= 20);
    }

    public static void unit5(int x)
    {
        System.out.println(x >= 0 ? "Положительное" : "Отрицательное");
    }

    public static boolean unit6(int x)
    {
        return (x < 0);
    }

    public static void unit7(String s)
    {
        System.out.println("Привет, " + s);
    }

    public static void unit8(int x)
    {
        String s = "Увы, не високосный";
        if ((x % 400 == 0) || (x % 100 != 0 && x % 4 == 0))
            s = "Високосный";

        System.out.println(s);
    }
}
