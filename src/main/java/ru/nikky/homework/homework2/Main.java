package ru.nikky.homework.homework2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //region Task 1
        //Задать целочисленный массив, состоящий из элементов 0 и 1.
        //Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0
        System.out.println(Arrays.toString(swapArrayVals(new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
        System.out.println();
        //endregion

        //region Task 2
        //Задать пустой целочисленный массив размером 8.
        //С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
        System.out.println(Arrays.toString(createArithmeticProgressionArray(3, 0, 8)));
        System.out.println();
        //endregion

        //region Task 3
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        //пройти по нему циклом, и числа меньшие 6 умножить на 2
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));
        System.out.println();
        //endregion

        //region Task 4
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        //и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        printMatrix(createIdentityMatrix(5, 1));
        System.out.println();
        printMatrix(createIdentityMatrix(5, 2));
        System.out.println();
        printMatrix(createIdentityMatrix(5, 3));
        System.out.println();
        //endregion

        //region Task 5
        //Задать одномерный массив и найти в нем минимальный и максимальный элементы
        int[] arr5 = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 1};
        findMinAndMax(arr5);
        System.out.println();
        //endregion

        //region Task 6
        //Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        //Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        //граница показана символами ||, эти символы в массив не входят.
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println();
        //endregion

        //region Task 7
        //Написать метод, которому на вход подается одномерный массив и число n
        //(может быть положительным, или отрицательным), при этом метод должен сместить все элементы
        //массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
        //вспомогательными массивами.
        //Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
        //[ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        //При каком n в какую сторону сдвиг можете выбирать сами.
        int[] arr71 = {1, 2, 3};
        shiftArray(arr71, 1);
        System.out.println(Arrays.toString(arr71));

        int[] arr72 = {3, 5, 6, 1};
        shiftArray(arr72, -2);
        System.out.println(Arrays.toString(arr72));
        //endregion
    }

    private static int[] swapArrayVals(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    private static int[] createArithmeticProgressionArray(int step, int startVal, int size) {
        if (size < 0) return null;
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = step * i + startVal;
        }
        return resultArray;
    }

    //modes:
    //1 - main diagonal filled with ones;
    //2 - second diagonal filled with ones;
    //3 - both diagonals filled with ones.
    private static int[][] createIdentityMatrix(int size, int mode){
        int[][] resultArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == j && mode != 2) || (i + j == size - 1 && mode != 1)){
                    resultArray[i][j] = 1;
                }
            }
        }
        return resultArray;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static void findMinAndMax(int[] array){
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            } else if (array[i] > max){
                max = array[i];
            }
        }
        System.out.printf("Min value = %d\nMax value = %d\n", min, max);
    }

    private static boolean checkBalance(int[] array){
        if (array.length == 1) return false;

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int leftSum = array[leftIndex];
        int rightSum = array[rightIndex];

        while (leftIndex != rightIndex - 1){
            if (leftSum < rightSum){
                leftSum += array[++leftIndex];
            } else {
                rightSum += array[--rightIndex];
            }
        }
        return leftSum == rightSum;
    }

    private static void shiftArray(int[] array, int step){
        //делаем step положительным
        if (step < 0){
            step += array.length;
        }
        for (int i = 0; i < step; i++) {
            int temp = array[array.length - 1];
            for (int j = array.length - 2; j >= 0; j--) {
                array[j + 1] = array[j];
            }
            array[0] = temp;
        }
    }
}
