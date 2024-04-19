package Opgave1;

public class ThreadArrivals extends Thread {
    int Id;
    int concurrentId;
    int nrOfArrivalsPerThread;
    Common common;
    PetersonsAlgorithm peterson;

    public ThreadArrivals(int Id, int maxNrOfArrivalsPerThread, Common common) {
        this.Id = Id;
        this.concurrentId = (Id + 1) % 2;
        this.nrOfArrivalsPerThread = maxNrOfArrivalsPerThread;
        this.common = common;
        this.peterson = common.getPeterson();
    }

    public void run() {
        for (int i = 0; i < nrOfArrivalsPerThread; i++) {
            this.peterson.setFlag(true, this.Id);
            this.peterson.setTurn(concurrentId);
            while(this.peterson.getFlag(concurrentId) && this.peterson.getTurn() == concurrentId);
            // DO SOMETHING
            this.peterson.setFlag(true, this.Id);
        }
    }
}
