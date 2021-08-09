package ru.nikky.homework.homework7;

public class Plate {

    private static int id;

    private int foodAmount;
    private int capacity;

    public Plate(int capacity, int foodAmount) {
        if (capacity <= 0) {
            this.capacity = 100;
            System.out.printf("Capacity of plate is 100 now.\n");
        } else {
            this.capacity = capacity;
        }
        addFood(foodAmount);

        id++;
    }

    public void info() {
        System.out.printf("Plate number %d has %d/%d food units.\n", id, foodAmount, capacity);
    }

    public boolean decreaseFood(int amount) {
        if (amount < 0) return false;
        if (foodAmount < amount) {
            return false;
        } else {
            foodAmount -= amount;
            return true;
        }
    }

    public void addFood(int amount) {
        if (amount < 0) return;
        foodAmount += amount;
        if (foodAmount >= capacity) {
            System.out.printf("Oops.. %d food units dropped from the plate.\n", foodAmount - capacity);
            foodAmount = capacity;
        }
    }

}
