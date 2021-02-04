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
		cat1.info();
		cat1.run(700);
		cat1.swim(10);
		System.out.println("");
		Cat cat2 = new Cat("Пушистик", 5);
		cat2.info();
		cat2.run(120);
		cat2.swim(0);

		System.out.println("");
		System.out.println("");

		Dog dog1 = new Dog("Шарик", 5);
		dog1.info();
		dog1.run(380);
		dog1.swim(8);
		System.out.println("");
		Dog dog2 = new Dog("Анчар", 10);
		dog2.info();
		dog2.run(400);
		dog2.swim(40);
		System.out.println("");
		Dog dog3 = new Dog("Балбес", 3);
		dog3.info();
		dog3.run(0);
		dog3.swim(-1);


		System.out.println("");
		System.out.println("");

	    Cat.getTotal();
	    Dog.getTotal();
	    Animal.getTotal();
    }
}
