package com.company;

public class Plate {
    private int eatValue;
    private String name;

    public Plate(String name, int eatValue)
    {
        this.eatValue = (eatValue >= 0) ? eatValue : 0;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean eating(int appetite)
    {
        if (appetite > this.eatValue)
        {
            System.out.println("В тарелке " + name + " слишком мало еды (" + this.eatValue + ")");
            return false;
        }
        else
        {
            this.eatValue -= appetite;
            System.out.println("В тарелке " + name + " осталось: " + this.eatValue);
            return true;
        }
    }

    public void info()
    {
        System.out.println("Тарелка " + this.name + ", содержит " + this.eatValue + " еды.");
    }

    public void append(int val)
    {
        if (val <= 0)
        {
            System.out.println("Вы вредный хозяин!");
            return;
        }
        System.out.println("Тарелка " + this.name + " была наполнена на " + val);
        this.eatValue += val;
    }
}
