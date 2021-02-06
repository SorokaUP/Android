package com.company;

public class Cat
{
    private String name;
    private boolean satiety;
    private int appetite;

    public Cat(String name, int appetite)
    {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
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

    public void infoSatiety()
    {
        System.out.printf("%s, %s \n", this.name, this.satiety ? "сыт :)" : "голоден :(");
    }
}
