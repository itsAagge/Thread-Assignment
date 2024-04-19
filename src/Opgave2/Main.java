package Opgave2;

import Opgave2.Common;
import Opgave2.ThreadArrivals;
import Opgave2.ThreadClerk;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Common common = new Common();
        Semaphore semaphore = new Semaphore(1);
        Semaphore waitingSemaphore = new Semaphore(0);
        ThreadArrivals door1 = new ThreadArrivals(0, 10, common, semaphore);
        ThreadArrivals door2 = new ThreadArrivals(1, 10, common, semaphore);
        ThreadClerk clerk = new ThreadClerk(1, 20, common, waitingSemaphore);
        door1.start();
        door2.start();
        clerk.start();
    }
}
