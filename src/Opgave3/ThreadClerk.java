package Opgave3;

import Opgave3.Common;

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
                common.customerServed();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
