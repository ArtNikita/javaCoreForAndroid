package ru.nikky.homework.homework13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier startRaceCB = new CyclicBarrier(CARS_COUNT + 1);

        final Race race = new Race(startRaceCB, new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        Thread[] carsThreadArray = new Thread[cars.length];
        for (int i = 0; i < cars.length; i++) {
            carsThreadArray[i] = new Thread(cars[i]);
            carsThreadArray[i].start();
        }
        try {
            startRaceCB.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        for (int i = 0; i < carsThreadArray.length; i++) {
            try {
                carsThreadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}


