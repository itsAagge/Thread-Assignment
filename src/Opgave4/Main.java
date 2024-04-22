package Opgave4;

import Opgave4.Common;
import Opgave4.ThreadArrivals;
import Opgave4.ThreadClerk;

public class Main {
    public static void main(String[] args) {
        Common common = new Common(20);
        ThreadArrivals door1 = new ThreadArrivals(0, 10, common);
        ThreadArrivals door2 = new ThreadArrivals(1, 10, common);
        ThreadClerk clerk1 = new ThreadClerk(0, 10, common);
        ThreadClerk clerk2 = new ThreadClerk(1, 10, common);
        door1.start();
        door2.start();
        clerk1.start();
        clerk2.start();
        try {
            door1.join();
            door2.join();
            clerk1.join();
            clerk2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("Total number of customers entered: " + common.getCustomersEntered());
        System.out.println("Total number of customers served: " + common.getCustomersServed());
    }
}
