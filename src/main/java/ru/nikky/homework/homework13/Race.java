package ru.nikky.homework.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private ArrayList<Stage> stages;
    private CyclicBarrier startRaceCB;
    private Lock winLock;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(CyclicBarrier startRaceCB, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.startRaceCB = startRaceCB;
        winLock = new ReentrantLock();
    }

    protected void awaitStartRaceCB() {
        try {
            startRaceCB.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    protected void lockWinner(String name) {
        if (winLock.tryLock()){
            System.out.printf("%s - WIN\n", name);
        }
    }
}