package Opgave1;

import Opgave4.Queue;

import java.util.Random;

public class Common {
    private int lastArrivedNumber;
    private int lastServedNumber;
    private PetersonsAlgorithm peterson;

    public Common() {
        this.lastArrivedNumber = 0;
        this.lastServedNumber = 0;
        this.peterson = new PetersonsAlgorithm();
    }

    public int getLastArrivedNumber() {
        return lastArrivedNumber;
    }

    public int getLastServedNumber() {
        return lastServedNumber;
    }

    public PetersonsAlgorithm getPeterson() {
        return peterson;
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
}
