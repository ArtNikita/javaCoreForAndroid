package ru.nikky.homework.homework11;

import java.util.ArrayList;
import java.util.Iterator;

public class Box <T extends Fruit> {
    private ArrayList<T> storage;

    public Box() {
        storage = new ArrayList<>();
    }

    public float getWeight(){
        float resultWeight = 0;
        for (T fruit : storage) {
            resultWeight += fruit.getWEIGHT();
        }
        return resultWeight;
    }

    public boolean compare(Box<?> another){
        return this.getWeight() == another.getWeight();
    }

    public void addFruit(T fruit){
        storage.add(fruit);
    }

    public T takeFruit(){
        if (storage.size() == 0) return null;
        return storage.remove(storage.size() - 1);
    }

    public void pourFruits(Box<T> to){
        if (to == this) return;
        Iterator<T> iterator = storage.iterator();
        while (iterator.hasNext()){
            to.addFruit(iterator.next());
            iterator.remove();
        }
    }

    public int getAmountOfFruits(){
        return storage.size();
    }
}
