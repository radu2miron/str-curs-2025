package edu.tucn.str.lecture3.ex0AtomicCounter;

/**
 * @author Radu Miron
 * @version 1
 */
public class MyThread extends Thread {
    private Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            counter.increment();
        }
    }
}
