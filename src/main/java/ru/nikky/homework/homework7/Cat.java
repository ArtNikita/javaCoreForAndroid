package ru.nikky.homework.homework7;

public class Cat {

    private boolean isWellFed;//сытый
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        if (appetite <= 0) {
            appetite = 20;
        } else {
            this.appetite = appetite;
        }
    }

    public boolean eat(Plate plate) {
        if (isWellFed) return false;
        if (plate.decreaseFood(appetite)) {
            isWellFed = true;
            return true;
        } else {
            return false;
        }
    }

    public void info() {
        System.out.printf("Cat %s is %s\n", name, isWellFed ? "well-fed!" : "hungry :(");
    }

}
