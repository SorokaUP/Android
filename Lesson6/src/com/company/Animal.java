package com.company;

public abstract class Animal {
    private String name;
    private int age;
    private static int Total;

    public Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
        Total++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void Run(int val)
    {
        System.out.println(name + " пробежал " + val + " метров.");
    }
    public void Swim(int val)
    {
        System.out.println(name + " проплыл " + val + " метров.");
    }

    public void Info()
    {
        System.out.printf("%s (%d лет)\n", this.getName(), this.getAge());
    }

    public static void getTotal()
    {
        System.out.println("Всего животных было создано: " + Total);
    }
}
