package ru.nikky.homework.homework6;

public class Main {
    public static void main(String[] args) {
        System.out.println(Animal.getAnimalsCount());   //0

        System.out.println(Dog.getDogsCount());         //0
        Animal dog01 = new Dog("Jora");
        dog01.run(500);                         //Dog Jora ran 500 meters!
        Animal dog02 = new Dog("Biba");
        dog02.run(501);                         //Too far for dog Biba!
        Animal dog03 = new Dog("Boba");
        dog03.swim(10);                         //Dog Boba swam 10 meters!
        dog03.swim(11);                         //Too far for Dog Boba!
        System.out.println(Dog.getDogsCount());         //3

        System.out.println(Animal.getAnimalsCount());   //3

        System.out.println(Cat.getCatsCount());         //0
        Animal cat01 = new Cat("Pupa");
        cat01.run(5);                           //Cat Pupa ran 5 meters!
        Animal cat02 = new Cat("Lupa");
        cat02.run(201);                         //Too far for cat Lupa!
        cat02.swim(1);                          //Cats can't swim :(
        System.out.println(Cat.getCatsCount());         //2

        System.out.println(Animal.getAnimalsCount());   //5

    }
}
