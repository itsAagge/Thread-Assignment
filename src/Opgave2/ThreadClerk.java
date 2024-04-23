package Opgave2;

import Opgave2.Common;

import java.util.concurrent.Semaphore;

public class ThreadClerk extends Thread {
    private int id;
    private int nrOfCustomers;
    private Common common;
    private Semaphore semaphore;

    public ThreadClerk(int id, int nrOfCustomers, Common common, Semaphore semaphore) {
        this.id = id;
        this.nrOfCustomers = nrOfCustomers;
        this.common = common;
        this.semaphore = semaphore;
    }

    public void run() {
        for (int i = 0; i < nrOfCustomers; i++) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            common.customerServed();
            common.TagerRanTid(1000000);
        }
    }
}
