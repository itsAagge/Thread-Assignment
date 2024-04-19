package Opgave1;

public class Main {
    public static void main(String[] args) {
        Common common = new Common();
        ThreadArrivals door1 = new ThreadArrivals(0, 10, common);
        ThreadArrivals door2 = new ThreadArrivals(1, 10, common);
        //ThreadClerk clerk = new ThreadClerk(1, 20, common);
        door1.start();
        door2.start();
        //clerk.start();
    }

}
