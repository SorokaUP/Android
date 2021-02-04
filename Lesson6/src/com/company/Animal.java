package com.company;

public abstract class Animal
{
    private String name;
    private int age;
    private static int total;

    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
        total++;
    }

    public String getName() {
        return name;
    }

    public void run(int val)
    {
        System.out.println(name + " пробежал " + val + " метров.");
    }
    public void swim(int val)
    {
        System.out.println(name + " проплыл " + val + " метров.");
    }

    public void info()
    {
        System.out.printf("%s (%d лет)\n", this.getName(), this.age);
    }

    public static void getTotal()
    {
        System.out.println("Всего животных было создано: " + total);
    }
}
