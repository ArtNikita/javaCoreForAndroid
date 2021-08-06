package ru.nikky.homework.homework6;

public class Dog extends Animal {

    private static int dogsCount;

    public static int getDogsCount() {
        return dogsCount;
    }

    public Dog(String name) {
        super(name, 500, 10);//Как вот здесь не хардкодить значения 500 и 10?
        dogsCount++;
    }
}
