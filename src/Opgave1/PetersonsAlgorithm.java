package Opgave1;

public class PetersonsAlgorithm {
    private boolean[] flag = new boolean[2];
    private volatile int turn = 0;

    public PetersonsAlgorithm() {
        this.flag[0] = false;
        this.flag[1] = false;
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
