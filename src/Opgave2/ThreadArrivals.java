package Opgave2;

import Opgave2.Common;

import java.util.concurrent.Semaphore;

public class ThreadArrivals extends Thread {
    private int id;
    private int nrOfArrivalsPerThread;
    private Common common;
    private Semaphore semaphore;
    private Semaphore waiting;

    public ThreadArrivals(int Id, int nrOfArrivalsPerThread, Common common, Semaphore semaphore, Semaphore waiting) {
        this.id = Id;
        this.nrOfArrivalsPerThread = nrOfArrivalsPerThread;
        this.common = common;
        this.semaphore = semaphore;
        this.waiting = waiting;
    }

    public void run() {
        for (int i = 0; i < nrOfArrivalsPerThread; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            common.customerArrived();
            semaphore.release();
            waiting.release();
            common.TagerRanTid(1000000);
        }
    }
}
