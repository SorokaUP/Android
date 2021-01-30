package com.company;

/*
    1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    2. Конструктор класса должен заполнять эти поля при создании объекта.
    3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    4. Создать массив из 5 сотрудников.
    Пример:
    Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
    persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
    persArray[1] = new Person(...);
    ...
    persArray[4] = new Person(...);

    5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/

public class Main {

    public static void main(String[] args) {
        Person e1 = new Person("Покровский Олег Олегович", "менеджер", "o.pokrov@ai.net", "88007008000", 35000, 41);
        e1.Info();

        Person[] eps = new Person[5];
        eps[0] = e1;
        eps[1] = new Person("Старшина Ирина Борисовна", "ст. менеджер", "i.starshina@ai.net", "88007008043", 75000, 28);
        eps[2] = new Person("Кулибин Сергей Петрович", "менеджер", "s.kulibin@ai.net", "88007008066", 44000, 30);
        eps[3] = new Person("Шашкова Алена Игоревна", "рук. отдела", "a.shashkova@ai.net", "88007008666", 98000, 37);
        eps[4] = new Person("Мальцов Семен Сергеевич", "зам. директора", "s.maltsov@ai.net", "88007008999", 140000, 48);

        System.out.println("");
        System.out.println("Сотрудники компании, кому за 40:");
        for (Person e : eps)
        {
            if (e.getAge() > 40)
                e.Info();
        }
    }
}
