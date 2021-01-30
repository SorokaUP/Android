package com.company;

public class Person {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private float wage;
    private int age;

    public Person(String FIO, String position, String email, String phone, float wage, int age)
    {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.wage = wage;
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public float getWage() {
        return wage;
    }

    public int getAge() {
        return age;
    }

    public void Info()
    {
        System.out.printf("Сотрудник: %s (%d лет) \n  Должность: %s \n  Телефон: %s \n  E-mail: %s \n  З/п: %.2f руб.", FIO, age, position, phone, email, wage);
        System.out.println("");
    }
}
