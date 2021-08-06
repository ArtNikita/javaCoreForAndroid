package ru.nikky.homework.homework6;

public class Cat extends Animal {

    private static int catsCount;

    public static int getCatsCount() {
        return catsCount;
    }

    public Cat(String name) {
        super(name, 200, 0);//Как вот здесь не хардкодить значения 200 и 0?
        catsCount++;
    }

    public boolean swim(int distance) {
        System.out.println("Cats can't swim :(");
        return false;
    }
}
