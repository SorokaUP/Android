package com.company;

public class Dog extends Animal
{
    private static int Total;

    public Dog(String name, int age)
    {
        super(name, age);
        Total++;
    }

    @Override
    public void Run(int val) {
        if (val > 500)
        {
            super.Run(500);
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
        if (val > 10)
        {
            super.Swim(10);
            System.out.printf("%s потом вылез, так как устал...\n", this.getName());
        }
        else if (val >= 0)
        {
            super.Swim(val);
        }
        else
        {
            System.out.printf("У %s случился когнетивный диссонанс...\n", this.getName());
        }
    }

    public static void getTotal()
    {
        System.out.println("Всего собак было создано: " + Total);
    }
}
