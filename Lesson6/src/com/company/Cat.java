package com.company;

public class Cat extends Animal
{
    private static int total;

    public Cat(String name, int age)
    {
        super(name, age);
        total++;
    }

    @Override
    public void run(int val) {
        if (val > 200)
        {
            super.run(200);
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
        if (val >= 0)
        {
            super.swim(0);
            System.out.printf("%s не стал мочить лапки, потом сохнуть долго...\n", this.getName());
        }
        else
        {
            System.out.printf("У %s случился когнетивный диссонанс...\n", this.getName());
        }
    }

    public static void getTotal()
    {
        System.out.println("Всего котов было создано: " + total);
    }
}
