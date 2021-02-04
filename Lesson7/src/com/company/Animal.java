package com.company;

public abstract class Animal {
    private String name;
    private int age;
    private static int total;
    private boolean satiety;
    private int appetite;

    public Animal(String name, int age, int appetite)
    {
        this.name = name;
        this.age = age;
        this.satiety = false;
        this.appetite = appetite;
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
    public void eating(Plate plate)
    {
        if (this.satiety)
        {
            System.out.println(this.name + " еще не голоден");
            return;
        }

        if (plate == null)
        {
            System.out.println(this.name + " крайне не доволен, что ему не дали тарелку с едой >.<");
        }
        else
        {
            if (this.appetite <= 0)
            {
                System.out.println("Кажется, что " + this.name + " болен, нужно срочно к ветеринару!");
                return;
            }
            System.out.println(this.name + " пробует кушать из тарелки " + plate.getName());
            this.satiety = plate.eating(this.appetite);
            System.out.println(this.name + ((this.satiety) ? " наелся и теперь сытый :)" : " не стал трогать и остался голодным :("));
        }
    }

    public void info()
    {
        System.out.printf("%s (%d лет), аппетит: %d\n", this.name, this.age, this.appetite);
    }

    public void infoSatiety()
    {
        System.out.printf("%s, %s \n", this.name, this.satiety ? "сыт :)" : "голоден :(");
    }

    public static void getTotal()
    {
        System.out.println("Всего животных было создано: " + total);
    }
}
