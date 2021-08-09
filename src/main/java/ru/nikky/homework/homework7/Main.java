package ru.nikky.homework.homework7;

public class Main {

    private static String delimiter = "-----------------";

    public static void main(String[] args) {

        Plate plate01 = new Plate(100, 120);
        plate01.info();
        System.out.println(delimiter);

        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Wiskas", 30);//70
        cats[1] = new Cat("Tolstyak", 50);//20
        cats[2] = new Cat("Murka", 15);//5
        cats[3] = new Cat("Turbo", 35);//hungry  // 20
        cats[4] = new Cat("Tito", 17);//hungry  // 3

        feedCats(cats, plate01);

        plate01.info();// 5/100
        System.out.println(delimiter);

        System.out.println("\n\n\n\nROUND 2!!!\n\n\n");

        plate01.addFood(50);
        plate01.info();// 55/100
        System.out.println(delimiter);

        feedCats(cats, plate01);
        plate01.info(); // 3/100
        System.out.println(delimiter);


    }

    private static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
            System.out.println(delimiter);
        }
    }
}
