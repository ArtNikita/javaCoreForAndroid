package ru.nikky.homework.homework9;

public class MyArraySizeException extends Throwable {
    public MyArraySizeException(int size) {
        super(String.valueOf(size));
    }
}
