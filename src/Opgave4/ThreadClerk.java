package Opgave4;

import Opgave4.Common;

public class ThreadClerk extends Thread {
    private int id;
    private int nrOfCustomers;
    private Common common;

    public ThreadClerk(int id, int nrOfCustomers, Common common) {
        this.id = id;
        this.nrOfCustomers = nrOfCustomers;
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < nrOfCustomers; i++) {
            try {
                common.customerServed(this.id);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            common.TagerRanTid(1000000);
        }
    }
}

