package com.company;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int r, int c, Object o)
    {
        super("Не удалось преобразовать объект в int по адресу ["+r+","+c+"]: " + o.toString());
    }
}
