package com.company;
/*
    Необходимо написать два метода, которые делают следующее:
    1) Создают одномерный длинный массив, например:

    static final int SIZE = 10 000 000;
    static final int HALF = size / 2;
    float[] arr = new float[size].

    2) Заполняют этот массив единицами.
    3) Засекают время выполнения: long a = System.currentTimeMillis().
    4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:

    arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

    5) Проверяется время окончания метода System.currentTimeMillis().
    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a).

    Отличие первого метода от второго:
        Первый просто бежит по массиву и вычисляет значения.
        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
*/

import java.util.Arrays;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        try
        {
            float[] arr1 = unit1();
            float[] arr2 = unit2();
            System.out.println("");
            System.out.println("Массивы расчитаны: " + (Arrays.equals(arr1, arr2) ? "ВЕРНО" : "ОШИБОЧНО"));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getStackTrace());
        }
    }

    public static float[] unit1()
    {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            //arr[i] = 1.0f; // Почему бы и нет -_-
            arr[i] = unitF(arr[i], i);
        }
        System.out.printf("Время выполнения в одном потоке: %d \n", (System.currentTimeMillis() - a));
        return arr;
    }

    public static float[] unit2() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        float[] arr1 = Arrays.copyOfRange(arr, 0, HALF);
        float[] arr2 = Arrays.copyOfRange(arr, HALF, SIZE);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    arr1[i] = unitF(arr1[i], i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    arr2[i] = unitF(arr2[i], i + HALF);
                }
            }
        });

        long a = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        /* Вариант 1 */
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);


        /* Вариант 2
        int i2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (i < HALF)
            {
                arr[i] = arr1[i];
            }
            else
            {
                arr[i] = arr2[i2];
                i2++;
            }
        }*/
        System.out.printf("Время выполнения в двух потоках: %d \n", (System.currentTimeMillis() - a));

        return arr;
    }

    private static float unitF(float val, int i)
    {
        return (float)(val * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
}
