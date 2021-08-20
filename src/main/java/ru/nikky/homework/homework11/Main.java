package ru.nikky.homework.homework11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final String DELIMITER = "---------------";

    public static void main(String[] args) {
        //region Task 1
        System.out.printf("%s\n\tTask 1\n%s\n", DELIMITER, DELIMITER);
        Integer[] intsArray = {1, 2, 3, 4, 5};
        System.out.printf("original array: %s\n", Arrays.toString(intsArray));
        System.out.printf("swapping (%d, %d) result: %s\n", 2, 4, swapElements(intsArray, 2, 4));
        System.out.printf("array after swapping: %s\n\n", Arrays.toString(intsArray));
        //endregion

        //region Task 2
        System.out.printf("%s\n\tTask 2\n%s\n", DELIMITER, DELIMITER);
        ArrayList<Integer> intsArrayList = convertToArrayList(intsArray);
        System.out.println(intsArrayList);
        //endregion

        //region Task 3
        System.out.printf("%s\n\tTask 3\n%s\n", DELIMITER, DELIMITER);
        Box<Apple> appleBox01 = new Box<>();
        Box<Apple> appleBox02 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        System.out.println("Empty box weight: " + appleBox01.getWeight());

        appleBox01.addFruit(new Apple());
        appleBox01.addFruit(new Apple());
        appleBox01.addFruit(new Apple());
        appleBox02.addFruit(new Apple());
        //appleBox01.pourFruits(orangeBox); Ошибка компиляции
        System.out.printf("Коробка 2 до пересыпания: вес - %f, кол-во - %d\n",
                appleBox02.getWeight(), appleBox02.getAmountOfFruits());
        System.out.printf("Коробка 1 до пересыпания: вес - %f, кол-во - %d\n",
                appleBox01.getWeight(), appleBox01.getAmountOfFruits());
        appleBox01.pourFruits(appleBox02);
        System.out.printf("Коробка 2 после пересыпания: вес - %f, кол-во - %d\n",
                appleBox02.getWeight(), appleBox02.getAmountOfFruits());
        System.out.printf("Коробка 1 после пересыпания: вес - %f, кол-во - %d\n",
                appleBox01.getWeight(), appleBox01.getAmountOfFruits());

        System.out.println();
        System.out.println(appleBox01.compare(appleBox01));//true
        System.out.println(appleBox01.compare(orangeBox));//true
        System.out.println(appleBox01.compare(appleBox02));//false
        System.out.println(appleBox02.compare(appleBox02));//true
        System.out.println();

        for (int i = 0; i < 4; i++) {
            orangeBox.addFruit(new Orange());
        }
        System.out.printf("Коробка c апельсинами: вес - %f, кол-во - %d\n",
                orangeBox.getWeight(), orangeBox.getAmountOfFruits());
        System.out.println(orangeBox.compare(appleBox02));//false
        for (int i = 0; i < 2; i++) {
            appleBox02.addFruit(new Apple());
        }
        System.out.printf("2 коробка c яблаками: вес - %f, кол-во - %d\n",
                appleBox02.getWeight(), appleBox02.getAmountOfFruits());
        System.out.println(orangeBox.compare(appleBox02));//true
        //endregion
    }


    /**
     * Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
     */
    public static <T> boolean swapElements(T[] array, int firstIndex, int secondIndex) {
        if (array == null || firstIndex < 0 || secondIndex < 0 ||
                firstIndex >= array.length || secondIndex >= array.length) return false;

        if (firstIndex == secondIndex) return true;

        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
        return true;
    }

    /**
     * Написать метод, который преобразует массив в ArrayList;
     */
    public static <T> ArrayList<T> convertToArrayList(T[] array){
        if (array == null) return null;
        /*
        Можно было бы и так. Пожалуй, самый лучший вариант.
        ArrayList<T> resultArrayList = new ArrayList<>(Arrays.asList(array));
         */
        ArrayList<T> resultArrayList = new ArrayList<>(array.length);
        resultArrayList.addAll(Arrays.asList(array));
        return resultArrayList;
    }
}