package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("Сорокин Владислав, 2021");
        System.out.println("----------------------------------------");
        System.out.println("unit1:");
        unit1();
        System.out.println("----------------------------------------");
        System.out.println("unit2:");
        unit2();
        System.out.println("----------------------------------------");
        System.out.println("unit3:");
        unit3();
        System.out.println("----------------------------------------");
        System.out.println("unit4:");
        unit4();
        System.out.println("----------------------------------------");
        System.out.println("unit5:");
        unit5();
        System.out.println("----------------------------------------");
        System.out.println("unit6:");
        boolean res6 = unit6(new int[] { 2, 2, 2, 1, 2, 2, 10, 1 });
        System.out.println(res6);
        System.out.println("----------------------------------------");
        System.out.println("unit7:");
        int[] arr = { 1, 2, 3, 4 };
        PrintArr(arr);
        unit7(arr, -3);
        PrintArr(arr);
        System.out.println("----------------------------------------");
    }

    public static void PrintArr(int[] arr)
    {
        System.out.println("");
        System.out.print("[ ");
        int cnt = arr.length;
        for (int i = 0; i < cnt; i++)
            System.out.print(arr[i] + (i + 1 < cnt ? ", " : ""));
        System.out.println(" ]");
    }

    public static void PrintArr2(int[][] arr)
    {
        System.out.println("");
        System.out.println("[ ");
        for (int i = 0; i < arr.length; i++)
            PrintArr(arr[i]);
        System.out.println("]");
    }

    // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void unit1()
    {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        PrintArr(arr);

        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] == 1) ? 0 : 1;

        PrintArr(arr);
    }

    // Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void unit2()
    {
        int[] arr = new int[8];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
            n += 3;
        }

        PrintArr(arr);
    }

    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void unit3()
    {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        PrintArr(arr);

        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];

        PrintArr(arr);
    }

    // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void unit4()
    {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = (i == j) ? 1 : 0;

        PrintArr2(arr);
    }

    // ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void unit5()
    {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int min = 0;
        int max = 0;

        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        PrintArr(arr);
        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }

    // ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean unit6(int[] arr)
    {
        if (arr.length < 2)
        {
            return false;
        }
        PrintArr(arr);

        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            sumRight = 0;
            for (int j = arr.length - 1; j > i; j--)
                sumRight += arr[j];
            if (sumLeft == sumRight) return true;
        }

        return false;
    }

    // **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    public static void unit7(int[] arr, int n)
    {
        if (n == 0 || arr.length < 2) return;

        for (int i = 0; i < Math.abs(n); i++)
        {
            if (n > 0)
                MovedItemsPlus(arr);
            else
                MovedItemsMinus(arr);
        }
    }

    public static void MovedItemsPlus(int[] arr)
    {
        int cnt = arr.length;

        int prev = 0;
        int curr = 0;
        for (int i = 0; i < cnt; i++) {
            if (i == 0)
            {
                prev = arr[i];
            }
            else
            {
                if (i + 1 != cnt)
                {
                    curr = arr[i];
                    arr[i] = prev;
                    prev = curr;
                }
                else
                {
                    arr[0] = arr[cnt - 1];
                    arr[cnt - 1] = prev;
                }
            }
        }
    }

    public static void MovedItemsMinus(int[] arr)
    {
        int cnt = arr.length;

        int next = 0;
        int curr = 0;
        for (int i = cnt - 1; i >= 0; i--) {
            if (i == cnt - 1)
            {
                next = arr[i];
            }
            else
            {
                if (i != 0)
                {
                    curr = arr[i];
                    arr[i] = next;
                    next = curr;
                }
                else
                {
                    arr[cnt - 1] = arr[0];
                    arr[0] = next;
                }
            }
        }
    }
}