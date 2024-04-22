package Opgave3;

import Opgave3.Common;

import java.util.concurrent.Semaphore;

public class ThreadArrivals extends Thread {
    private int id;
    private int nrOfArrivalsPerThread;
    private Common common;

    public ThreadArrivals(int Id, int nrOfArrivalsPerThread, Common common) {
        this.id = Id;
        this.nrOfArrivalsPerThread = nrOfArrivalsPerThread;
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < nrOfArrivalsPerThread; i++) {
            common.customerArrived(this.id);
            common.TagerRanTid(1000000);
        }
    }
}
