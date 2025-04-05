package edu.tucn.str.lecture4.ex4simplesemaphore;

import edu.tucn.str.lecture4.util.ActivityUtils;

import java.util.concurrent.Semaphore;

/**
 * @author Radu Miron
 * @version 1
 */
public class ThreadSemaphore extends Thread {
    private Semaphore semaphore;

    public ThreadSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        ActivityUtils.doActivity(Thread.currentThread().getName() + " - A1", 0);

        try {
            semaphore.acquire();
            ActivityUtils.doActivity(Thread.currentThread().getName() + " - A2", 0);
        } catch (InterruptedException exception) {

        } finally {
            semaphore.release();
        }

        ActivityUtils.doActivity(Thread.currentThread().getName() + " - A3", 0);
    }
}
