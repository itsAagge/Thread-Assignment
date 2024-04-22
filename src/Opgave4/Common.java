package Opgave4;

import com.github.javafaker.Faker;

import java.util.Random;

public class Common {
    private int queueMaxSize;
    private Queue<String> queue;
    private Faker faker = new Faker();
    private volatile int customersEntered = 0;
    private volatile int customersServed = 0;

    public Common(int queueMaxSize) {
        this.queueMaxSize = queueMaxSize;
        this.queue = new Queue<>(queueMaxSize);
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

    public synchronized void customerArrived(int id) throws InterruptedException {
        if (queue.size() == queueMaxSize) wait();
        String fakeCustomer = faker.name().firstName();
        queue.add(fakeCustomer);
        System.out.println("Customer arrived from door " + (id + 1) + ". Name: " + fakeCustomer);
        this.customersEntered++;
        notifyAll();
    }

    public synchronized void customerServed(int id) throws InterruptedException {
        if (queue.isEmpty()) wait();
        System.out.println("Served cusomer " + queue.remove() + " by clerk " + (id + 1));
        notifyAll();
        this.customersServed++;
    }

    public int getCustomersEntered() {
        return customersEntered;
    }

    public int getCustomersServed() {
        return customersServed;
    }
}
