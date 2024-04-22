package Opgave1;

public class ThreadArrivals extends Thread {
    private int id;
    private int concurrentId;
    private int nrOfArrivalsPerThread;
    private Common common;

    public ThreadArrivals(int id, int nrOfArrivalsPerThread, Common common) {
        this.id = id;
        this.concurrentId = (id + 1) % 2;
        this.nrOfArrivalsPerThread = nrOfArrivalsPerThread;
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < nrOfArrivalsPerThread; i++) {
            this.common.setFlag(true, this.id);
            this.common.setTurn(concurrentId);
            while(this.common.getFlag(concurrentId) && this.common.getTurn() == concurrentId);
            common.customerArrived();
            this.common.setFlag(false, this.id);
            common.TagerRanTid(1000000);
        }
    }
}
