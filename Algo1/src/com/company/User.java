package com.company;

import java.util.*;

public class User {
    private final String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User {" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object u) {
        boolean result;
        if (this == u) {
            result = true;
        } else if (u == null || getClass() != u.getClass()) {
            result = false;
        } else {
            User person = (User) u;
            result = age == person.age && Objects.equals(name, person.name);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
