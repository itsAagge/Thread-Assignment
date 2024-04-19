package Opgave1;

public class ThreadArrivals extends Thread {
    int id;
    int concurrentId;
    int nrOfArrivalsPerThread;
    private Common common;

    public ThreadArrivals(int Id, int nrOfArrivalsPerThread, Common common) {
        this.id = Id;
        this.concurrentId = (Id + 1) % 2;
        this.nrOfArrivalsPerThread = nrOfArrivalsPerThread;
        this.common = common;
    }

    public void run() {
        for (int i = 0; i < nrOfArrivalsPerThread; i++) {
            this.common.setFlag(true, this.id);
            this.common.setTurn(concurrentId);
            while(this.common.getFlag(concurrentId) && this.common.getTurn() == concurrentId);
            common.customerArrived(this.id);
            this.common.setFlag(true, this.id);
        }
    }
}
