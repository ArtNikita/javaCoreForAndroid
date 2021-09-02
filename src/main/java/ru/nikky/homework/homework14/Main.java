package ru.nikky.homework.homework14;

public class Main {
    /**
     * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
     * необходимо выбросить RuntimeException.
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
     */
    public static int[] cutArrayAfterFour(int[] array) {
        int fourIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) fourIndex = i;
        }
        if (fourIndex == -1) throw new RuntimeException();
        int[] resultArray = new int[array.length - fourIndex - 1];
        System.arraycopy(array, fourIndex + 1, resultArray, 0, resultArray.length);
        return resultArray;
    }

    /**
     * Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
     * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     * [ 1 1 1 4 4 1 4 4 ] -> true
     * [ 1 1 1 1 1 1 ] -> false
     * [ 4 4 4 4 ] -> false
     * [ 1 4 4 1 1 4 3 ] -> false
     * Исходя из последнего примера, нужно бросать false, если есть что-то кроме 1 или 4
     */
    public static boolean isOnesAndFoursArray(int[] array) {
        boolean containsOne = false;
        boolean containsFour = false;
        for (int entry : array) {
            if (entry == 1) containsOne = true;
            else if (entry == 4) containsFour = true;
            else return false;
        }
        return containsOne && containsFour;
    }
}
