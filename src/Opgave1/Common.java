package Opgave1;

import java.util.Random;

public class Common {
    private int lastArrivedNumber = 0;
    private int lastServedNumber = 0;
    private boolean[] flag = new boolean[2];
    private volatile int turn = 0;

    public Common() {
        flag[0] = false;
        flag[1] = false;
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

    public void customerArrived() {
        System.out.println("Customer arrived. Nr: " + ++this.lastArrivedNumber);
    }

    public void customerServed() {
        System.out.println("Served cusomer nr. " + ++this.lastServedNumber);
    }

    public boolean getFlag(int id) {
        return flag[id];
    }

    public void setFlag(boolean bool, int id) {
        this.flag[id] = bool;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
