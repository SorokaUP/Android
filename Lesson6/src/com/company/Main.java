package com.company;

/*
    1. Создать классы Собака и Кот с наследованием от класса Животное.
    2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
    3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
    4. * Добавить подсчет созданных котов, собак и животных.
 */

public class Main {

    public static void main(String[] args) {
		Cat cat1 = new Cat("Мурзик", 7);
		cat1.Info();
		cat1.Run(700);
		cat1.Swim(10);
		System.out.println("");
		Cat cat2 = new Cat("Пушистик", 5);
		cat2.Info();
		cat2.Run(120);
		cat2.Swim(0);

		System.out.println("");
		System.out.println("");

		Dog dog1 = new Dog("Шарик", 5);
		dog1.Info();
		dog1.Run(380);
		dog1.Swim(8);
		System.out.println("");
		Dog dog2 = new Dog("Анчар", 10);
		dog2.Info();
		dog2.Run(400);
		dog2.Swim(40);
		System.out.println("");
		Dog dog3 = new Dog("Балбес", 3);
		dog3.Info();
		dog3.Run(0);
		dog3.Swim(-1);


		System.out.println("");
		System.out.println("");

	    Cat.getTotal();
	    Dog.getTotal();
	    Animal.getTotal();
    }
}
