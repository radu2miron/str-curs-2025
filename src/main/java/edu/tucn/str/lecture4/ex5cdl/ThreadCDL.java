package edu.tucn.str.lecture4.ex5cdl;

import java.util.concurrent.CountDownLatch;

/**
 * @author Radu Miron
 * @version 1
 */
public class ThreadCDL extends Thread {
    private CountDownLatch countDownLatch;
    private int delay;

    public ThreadCDL(CountDownLatch countDownLatch, int delay) {
        this.countDownLatch = countDownLatch;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            //simulate an initialization operation
            Thread.sleep(delay);

            System.out.println(Thread.currentThread().getName() + " is ready");

            countDownLatch.countDown();
            countDownLatch.await();

            System.out.println(Thread.currentThread().getName() + " started");
            //the functional part of the thread
        } catch (InterruptedException e) {
        }
    }
}
