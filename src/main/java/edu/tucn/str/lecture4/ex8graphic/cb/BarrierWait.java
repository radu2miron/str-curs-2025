package edu.tucn.str.lecture4.ex8graphic.cb;

public class BarrierWait implements Runnable {
    public Barrier barrier;

    public BarrierWait(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
