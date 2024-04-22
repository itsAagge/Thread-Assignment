package Opgave4;

import Opgave4.Common;

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
            try {
                common.customerArrived(this.id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}