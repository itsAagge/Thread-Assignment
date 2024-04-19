package Opgave3;

import java.util.Random;

public class Common {
    private int lastArrivedNumber = 0;
    private int lastServedNumber = 0;

    public Common() {
    }

    public int getLastArrivedNumber() {
        return lastArrivedNumber;
    }

    public int getLastServedNumber() {
        return lastServedNumber;
    }

    public void TagerRanTid (int max) {
        int x,y;
        Random r = new Random(1023);
        int max2 = Math.abs(r.nextInt()) % max +1;
        for (int j=0; j<max2; j++) {
            for (int i=0; i<max2; i++) {
                x = i + j;
                y = i - j;
            }
        }
    }

    public synchronized void customerArrived() {
        TagerRanTid(100);
        System.out.println("Customer arrived. Nr: " + ++this.lastArrivedNumber);
        notify();
    }

    public synchronized void customerServed() throws InterruptedException {
        if (lastServedNumber == lastArrivedNumber) wait();
        TagerRanTid(200);
        System.out.println("Served cusomer nr. " + ++this.lastServedNumber);
    }
}
