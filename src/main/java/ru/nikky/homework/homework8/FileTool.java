package ru.nikky.homework.homework8;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileTool {

    /**
     * Task 2:
     * Написать метод, «склеивающий» файлы, то есть вначале идет
     * текст из первого файла, потом текст из второго.
     *
     * @param destinationFile
     * @param files
     * @return
     */
    public static boolean concatFiles(File destinationFile, File... files) {
        try {
            FileWriter fileWriter = new FileWriter(destinationFile);
            FileReader fileReader;
            for (File file : files) {
                fileWriter.append(file.getName()).append(":\n");
                fileReader = new FileReader(file);
                int i;
                while ((i = fileReader.read()) != -1) {
                    fileWriter.append((char) i);
                }
                fileWriter.append("\n");
                fileWriter.flush();
                fileReader.close();
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void printTree(File dir, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(dir.getName());

        if (dir.isFile()) return;//exit if dir is File (first iteration)

        File[] files = dir.listFiles();

        int dirsAmount = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                dirsAmount++;
            }
        }

        int dirsCount = 0;
        int filesCount = 0;

        //можно было бы и через рекурсию, неважно
        for (File file : files) {
            if (file.isFile()) {
                System.out.print(indent);
                if (++filesCount == files.length) {
                    System.out.print("└─");
                } else {
                    System.out.print("├─");
                }
                System.out.println(file.getName());
            }
        }

        for (File file : files) {
            if (file.isDirectory()) {
                printTree(file, indent, ++dirsCount == dirsAmount);
            }
        }
    }

    /**
     * Task 3:
     * Написать метод, который проверяет присутствует ли указанное
     * пользователем слово в файле (работаем не только с латиницей).
     *
     * @param file
     * @param word
     * @return
     */
    public static boolean fileContainsWord(File file, String word) {
        if (!file.isFile()) {
            System.out.println("Вы передали не файл!");
            return false;
        }
        try {
            FileReader fileReader = new FileReader(file);
            StringBuilder fileContentSB = new StringBuilder(100);
            int i;
            while ((i = fileReader.read()) != -1) {
                fileContentSB.append((char) i);
            }
            return fileContentSB.toString().contains(word);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Task 4:
     * Написать метод, проверяющий, есть ли указанное слово в одном из файлов
     * в папке (например, мы указываем папку, в папке 4-5 файлов, мы должны понять,
     * существует ли указанное слово в одном из этих файлов, если да, выводим соответствующую информацию).
     *
     * @param directory
     * @param word
     */
    public static void directoryContainsWord(File directory, String word) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile() && FileTool.fileContainsWord(file, word)) {
                System.out.printf("File \"%s\" located in \"%s\" contains word \"%s\"\n", file.getName(), file.getPath(), word);
            }
            if (file.isDirectory()) {
                FileTool.directoryContainsWord(file, word);
            }
        }
    }
}
