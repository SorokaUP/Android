package com.company;

public class Cat extends Animal {
    private static int Total;

    public Cat(String name, int age)
    {
        super(name, age);
        Total++;
    }

    @Override
    public void Run(int val) {
        if (val > 200)
        {
            super.Run(200);
            System.out.println("И устал, так как не может бежать дольше...");
        }
        else if (val >= 0)
        {
            super.Run(val);
        }
        else
        {
            System.out.printf("У %s случился когнетивный диссонанс...\n", this.getName());
        }
    }

    @Override
    public void Swim(int val) {
        if (val >= 0)
        {
            super.Swim(0);
            System.out.printf("%s не стал мочить лапки, потом сохнуть долго...\n", this.getName());
        }
        else
        {
            System.out.printf("У %s случился когнетивный диссонанс...\n", this.getName());
        }
    }

    public static void getTotal()
    {
        System.out.println("Всего котов было создано: " + Total);
    }
}
