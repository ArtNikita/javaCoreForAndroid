package ru.nikky.homework.homework8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //region Task1
        //1. Создать 2 текстовых файла, примерно по 50-100
        // символов в каждом (особого значения не имеет);
        File dir = new File("C:\\sandbox");
        if (!dir.exists() && !dir.mkdirs()) {
            System.out.println("Ошибка при создании папки, выход из программы.");
            return;
        }
        File file01 = new File(dir.getAbsolutePath() + "\\file01.txt");
        File file02 = new File(dir.getAbsolutePath() + "\\file02.txt");
        try {
            FileWriter fileWriter01 = new FileWriter(file01);
            FileWriter fileWriter02 = new FileWriter(file02);
            fileWriter01.write("Написать метод, который проверяет присутствует ли указанное пользователем " +
                    "слово в файле (we work not only with the Latin alphabet).");
            fileWriter02.write("Написать метод, проверяющий, есть ли указанное слово в одном из файлов в папке " +
                    "(for example, we indicate a folder in a folder of 4-5 files, we must understand if the specified" +
                    " word exists in one of these files, if so, we display the appropriate information).");
            fileWriter01.close();
            fileWriter02.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //endregion

        //Task2
        File directionFile = new File("C:\\sandbox\\directionFile.txt");
        if (!directionFile.exists()) {
            try {
                directionFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(FileTool.concatFiles(directionFile, file01, file02));//true

        //Task3
        System.out.println("\nTask3");
        System.out.println(FileTool.fileContainsWord(directionFile, "Nikita"));//false
        System.out.println(FileTool.fileContainsWord(directionFile, "Никита"));//false
        System.out.println(FileTool.fileContainsWord(directionFile, "Написать"));//true
        System.out.println(FileTool.fileContainsWord(directionFile, "example"));//true

        //Task4
        System.out.println("\nTask4");
        FileTool.directoryContainsWord(dir, "example");
    }
}
