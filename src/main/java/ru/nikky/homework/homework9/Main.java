package ru.nikky.homework.homework9;

public class Main {
    public static void main(String[] args) {
        /*
        В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета.
         */
        String[][] array01 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};
        String[][] array02 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "a", "3", "4"},
                {"1", "2", "3", "4"}};
        String[][] array03 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "3", "4"},
                {"1", "2", "3", "4"}};
        try {
            System.out.println(sumValuesInSquareArray(array01));//40
//            System.out.println(sumValuesInSquareArray(array02));
//            System.out.println(sumValuesInSquareArray(array03));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Change array size!");
        } catch (MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Change array value!");
        }
    }

    /**
     * Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     *
     * @param array is a square array of Strings that contain int values
     */
    private static int sumValuesInSquareArray(String[][] array) throws MyArraySizeException{
        //check array dimension
        if (array.length != 4) throw new MyArraySizeException(array.length);
        for (String[] partOfArray : array) {
            if (partOfArray.length != 4) throw new MyArraySizeException(partOfArray.length);
        }

        /*
        Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
        Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
        или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
        в какой именно ячейке лежат неверные данные.
         */
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.valueOf(array[i][j]);
                } catch (NumberFormatException e) {//можно еще обработать случай, когда размерности int недостаточно
                    throw new MyArrayDataException(String.format("Value \"%s\" in [%d, %d] position",
                            array[i][j], i, j));
                }
            }
        }
        return sum;
    }
}
