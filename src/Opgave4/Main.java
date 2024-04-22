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
        //Evt. kunne man lave en CommonArrivals underklasse, så de to synchronized metoder ikke er i samme monitor
    }
}
