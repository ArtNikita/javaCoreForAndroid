package ru.nikky.homework.homework12;

import java.util.Arrays;

public class Main {
    private static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        System.out.println("In this program size is always even!");
        float[] arr01 = method01(SIZE % 2 == 0 ? SIZE : SIZE + 1);
        float[] arr02 = method02(SIZE % 2 == 0 ? SIZE : SIZE + 1, 2);
        System.out.println(Arrays.equals(arr01, arr02));
    }

    private static float[] method01(int size) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            //я немного изменил формулу: добавил к 5 и 2 "f"
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
        }
        long finishTime = System.currentTimeMillis();
        System.out.printf("Simple method time: %f sec.\n", (finishTime - startTime) / 1000f);
        return arr;
    }

    private static float[] method02(int size, int numOfThreads) {
        class ArrayThread extends Thread {
            int position;
            float[] arrayPart;

            public ArrayThread(int position, float[] arrayPart) {
                this.position = position;
                this.arrayPart = arrayPart;
            }

            @Override
            public void run() {
                for (int j = 0; j < arrayPart.length; j++) {
                    int i = position * arrayPart.length + j;
                    arrayPart[j] = (float) (arrayPart[j] * Math.sin(0.2f + i / 5f) *
                            Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f));
                }
            }
        }

        float[] arr = new float[size];
        Arrays.fill(arr, 1f);
        long startTime = System.currentTimeMillis();
        if (size % numOfThreads != 0) numOfThreads = 2;//для упрощения
        Thread[] threads = new Thread[numOfThreads];
        float[][] arrs = new float[numOfThreads][];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = new float[size / numOfThreads];
            System.arraycopy(arr, i * arrs[i].length, arrs[i], 0, arrs[i].length);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ArrayThread(i, arrs[i]);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < arrs.length; i++) {
            System.arraycopy(arrs[i], 0, arr, i * arrs[i].length, arrs[i].length);
        }
        long finishTime = System.currentTimeMillis();
        System.out.printf("Concurrent (%d threads) method time: %f sec.\n",
                numOfThreads, (finishTime - startTime) / 1000f);
        return arr;
    }
}



