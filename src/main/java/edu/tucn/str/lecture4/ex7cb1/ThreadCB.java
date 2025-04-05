package edu.tucn.str.lecture4.ex7cb1;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Radu Miron
 * @version 1
 */
public class ThreadCB extends Thread {
    CyclicBarrier cyclicBarrier;
    int delay;

    public ThreadCB(CyclicBarrier cyclicBarrier, int delay) {
        this.cyclicBarrier = cyclicBarrier;
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true){
            try {
                //simulate an initialization operation
                Thread.sleep(delay);

                System.out.println(Thread.currentThread().getName() + " is ready");

                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + " started");
                //the functional part of the thread
            } catch (Exception e) {
            }
        }
    }
}
