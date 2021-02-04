package com.company;

public class Dog extends Animal
{
    private static int total;

    public Dog(String name, int age, int appetite)
    {
        super(name, age, appetite);
        total++;
    }

    @Override
    public void run(int val) {
        if (val > 500)
        {
            super.run(500);
            System.out.println("И устал, так как не может бежать дольше...");
        }
        else if (val >= 0)
        {
            super.run(val);
        }
        else
        {
            System.out.printf("У %s случился когнетивный диссонанс...\n", this.getName());
        }
    }

    @Override
    public void swim(int val) {
        if (val > 10)
        {
            super.swim(10);
            System.out.printf("%s потом вылез, так как устал...\n", this.getName());
        }
        else if (val >= 0)
        {
            super.swim(val);
        }
        else
        {
            System.out.printf("У %s случился когнетивный диссонанс...\n", this.getName());
        }
    }

    @Override
    public void eating(Plate plate) {
        super.eating(plate);
    }

    public static void getTotal()
    {
        System.out.println("Всего собак было создано: " + total);
    }
}
