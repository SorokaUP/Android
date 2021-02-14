package com.company;

/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера
   необходимо бросить исключение com.company.MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе
   массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено
   исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения com.company.MyArraySizeException и MyArrayDataException
   и вывести результат расчета.
*/

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int res = 0;
        try
        {
            Object[][] arr = getGoodArray();
            //Object[][] arr = getBadSizeArray();
            //Object[][] arr = getBadDataArray();
            System.out.println(Arrays.deepToString(arr));
            System.out.println("");

            res = method(arr);
        }
	    catch (MyArraySizeException se)
        {
            System.out.println(se.getMessage());
        }
	    catch (MyArrayDataException de)
        {
            System.out.println(de.getMessage());
        }
	    catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
	    finally
        {
            System.out.println("Результат суммирования массива: " + res);
        }
    }

    static final int arrSize = 4;
    public static int method(Object[][] arr) throws MyArraySizeException, MyArrayDataException {
        int res = 0;
        if (arr.length != arrSize)
        {
            throw new MyArraySizeException(arrSize);
        }
        for (Object[] a : arr)
        {
            if (a.length != arrSize)
            {
                throw new MyArraySizeException(arrSize);
            }
        }
        for (int r = 0; r < arrSize; r++)
        {
            for (int c = 0; c < arrSize; c++)
            {
                try
                {
                    res += (int)arr[r][c];
                }
                catch (ClassCastException e)
                {
                    throw new MyArrayDataException(r,c,arr[r][c]);
                }
            }
        }
        return res;
    }

    static final Random random = new Random();
    public static Object[][] getGoodArray()
    {
        Object[][] res = new Object[arrSize][arrSize];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = random.nextInt(10) + 1;
            }
        }
        return res;
    }

    public static Object[][] getBadSizeArray()
    {
        Object[][] res = new Object[arrSize][arrSize+1];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = random.nextInt(10) + 1;
            }
        }
        return res;
    }

    public static Object[][] getBadDataArray()
    {
        Object[][] res = new Object[arrSize][arrSize];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = (i + 1 != j - 1) ? random.nextInt(10) + 1 : "ы";
            }
        }
        return res;
    }
}
