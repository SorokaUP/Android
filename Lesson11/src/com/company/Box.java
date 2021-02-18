package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Box<T extends  Fruit> {

    private ArrayList<T> items;
    private final int maxItems = 100;

    public Box() {
        this.items = new ArrayList<T>();
    }

    public ArrayList<T> getItems() {
        return this.items;
    }

    // Добавляем фрукты в ящик
    public boolean addItems(T item) {
        if (this.items.size() == maxItems)
        {
            System.out.println("Коробка уже полна");
            return false;
        }
        this.items.add(item);
        return true;
    }

    // Извлекаем фрукты
    public Fruit[] outItems(int qnt) {
        if (qnt <= 0)
        {
            System.out.println("Нельзя изъять: " + qnt);
            return null;
        }
        if (this.items.size() < qnt)
            qnt = this.items.size();
        if (qnt == 0)
        {
            System.out.println("В коробке уже пусто");
            return null;
        }

        Fruit[] res = new Fruit[qnt];
        for (int i = qnt - 1; i >= 0; i--) {
            res[i] = this.items.get(i);
            this.items.remove(i);
        }
        return res;
    }

    public float getWeight()
    {
        return (this.items.size() == 0)
                ? 0
                : this.items.get(0).getWeight() * this.items.size();
    }

    public boolean addFromBox(Box<T> box)
    {
        int qntOut = box.getItems().size();
        if (this.items.size() == maxItems)
        {
            System.out.println("Коробка полна");
            return false;
        }
        if (this.items.size() + qntOut > maxItems)
            qntOut = qntOut - (this.items.size() + qntOut - maxItems);
        System.out.println("Будет пересыпано " + qntOut + " фруктов.");

        Fruit[] fromBox = box.outItems(qntOut);
        if (fromBox == null || fromBox.length == 0)
            return false;

        for (int i = 0; i < fromBox.length; i++) {
            this.addItems((T)fromBox[i]);
        }
        System.out.println("Теперь в нашей коробке: " + this.items.size() + " фруктов");
        System.out.println("Теперь в чужой коробке: " + box.getItems().size() + " фруктов");

        return true;
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }
}
