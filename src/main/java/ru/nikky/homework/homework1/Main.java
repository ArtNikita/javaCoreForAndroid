package ru.nikky.homework.homework1;

public class Main {
    //Task 1
    //Создать пустой проект в IntelliJ IDEA и прописать метод main()
    public static void main(String[] args) {
        //region Task 2
        // Создать переменные всех пройденныхтипов данных и инициализировать их значения
        byte byteVal = -128;
        short shortVal = -32768;
        int intVal = -2147483648;
        long longVal = -9223372036854775808L;
        float floatVal = 1.4E-45f;
        double doubleVal = 4.9e-324;
        char charVal = '\u26c4';
        boolean booleanVal = false;
        //endregion

        //Testing methods
        System.out.println(calcExpression(2.39f, 3.14f, 7.18f, 0.3f));//64.7052(6)
        System.out.println();

        System.out.println(isSumBetween10And20(1, 9));//true
        System.out.println(isSumBetween10And20(21, -1));//true
        System.out.println(isSumBetween10And20(10, -1));//false
        System.out.println(isSumBetween10And20(15, 15));//false
        System.out.println();

        whetherInputIsPositiveOrNegative(3);//+
        whetherInputIsPositiveOrNegative(-3);//-
        whetherInputIsPositiveOrNegative(0);//+
        System.out.println();

        System.out.println(isInputNegative(3));//false
        System.out.println(isInputNegative(-3));//true
        System.out.println(isInputNegative(0));//false
        System.out.println();

        greeting("Никита");//Привет, Никита!
        System.out.println();

        ifYearIsLeap(100);//-
        ifYearIsLeap(400);//+
        ifYearIsLeap(2000);//+
        ifYearIsLeap(2003);//-
        ifYearIsLeap(2004);//+
        ifYearIsLeap(2100);//-
        ifYearIsLeap(2400);//+
    }

    //region Task 3
    //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – аргументы этого метода, имеющие тип float
    private static float calcExpression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
    //endregion

    //region Task 4
    //Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
    //от 10 до 20 (включительно), если да – вернуть true, в противном случае – false
    private static boolean isSumBetween10And20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    //endregion

    //region Task 5
    //Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    //положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    private static void whetherInputIsPositiveOrNegative(int input) {
        System.out.printf("%d - %s число.\n", input, input >= 0 ? "положительное" : "отрицательное");
    }
    //endregion

    //region Task 6
    //Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть
    //true, если число отрицательное, и вернуть false если положительное.
    private static boolean isInputNegative(int input) {
        return input < 0; //считаем, что 0 - положительный
    }
    //endregion

    //region Task 7
    //Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    //Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
    private static void greeting(String name) {
        System.out.printf("Привет, %s!\n", name);
    }
    //endregion

    //region Task 8
    //Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
    //Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static void ifYearIsLeap(int year) {
        boolean isLeap = false;
        if (year % 400 == 0) {
            isLeap = true;
        } else if (year % 100 == 0) {
            isLeap = false;
        } else if (year % 4 == 0) {
            isLeap = true;
        }
        System.out.printf("%d год -%s високосный.\n", year, isLeap ? "" : " не");
    }
    //endregion
}
