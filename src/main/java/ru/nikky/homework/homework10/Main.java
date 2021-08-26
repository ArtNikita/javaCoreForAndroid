package ru.nikky.homework.homework10;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //region Task1
        /*
        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово.
         */
        String originalString = "some words bla bla ok words nice geek brains geek bla";
        String[] originalArray = originalString.split(" ");

        //Как можно было бы здесь отсортировать TreeMap по Value, а не Key?
        TreeMap<String, Integer> wordsStatistics = new TreeMap<>();
        for (String word : originalArray) {
            if (!wordsStatistics.containsKey(word)){
                wordsStatistics.put(word, 1);
            } else {
                wordsStatistics.put(word, wordsStatistics.get(word) + 1);
            }
        }
        System.out.println(wordsStatistics);
        //endregion

        //region Task2
        System.out.println();
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("+79117777777", "Artamonov");
        phoneBook.add("+79217777777", "Prokopov");
        phoneBook.add("+79317777777", "Dyakov");
        phoneBook.add("+79417777777", "Artamonov");
        phoneBook.add("+79517777777", "Sherstneva");
        phoneBook.add("+79617777777", "Artamonov");

        System.out.println("Artamonov: " + phoneBook.get("Artamonov"));
        System.out.println("Pupkin: " + phoneBook.get("Pupkin"));
        System.out.println("Dyakov: " + phoneBook.get("Dyakov"));
        //endregion
    }
}
