package ru.nikky.homework.homework6;

abstract class Animal {

    private static int animalsCount;

    private String name;
    private String className;

    private int runDistance;
    private int swimDistance;

    public Animal(String name, int runDistance, int swimDistance) {
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.name = name;

        animalsCount++;
        className = getClass().getSimpleName();
    }

    public boolean run(int distance) {
        if (distance <= runDistance) {
            System.out.printf("%s %s ran %d meters!\n", className, name, distance);
            return true;
        } else {
            System.out.printf("Too far for %s %s!\n", className.toLowerCase(), name);
            return false;
        }
    }

    public boolean swim(int distance) {
        if (distance <= swimDistance) {
            System.out.printf("%s %s swam %d meters!\n", className, name, distance);
            return true;
        } else {
            System.out.printf("Too far for %s %s!\n", className, name);
            return false;
        }
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }
}
