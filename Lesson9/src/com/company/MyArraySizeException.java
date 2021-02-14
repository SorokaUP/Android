package com.company;

public class MyArraySizeException extends Exception {
    public MyArraySizeException(int size)
    {
        super("Размерность массива не соответствует размеру: " + size + "x" + size);
    }
}
