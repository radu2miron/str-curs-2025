package edu.tucn.str.lecture4.ex3lock;

import edu.tucn.str.lecture4.util.ActivityUtils;

import java.util.concurrent.locks.Lock;

/**
 * @author Radu Miron
 * @version 1
 */
public class ThreadLock extends Thread {
    private Lock lock;

    public ThreadLock(Lock lock) {
        this.lock = lock;
    }

    public void run() {
        ActivityUtils.doActivity(Thread.currentThread().getName() + " - A1", 0);

        try {
            lock.lock();
            ActivityUtils.doActivity(Thread.currentThread().getName() + " - A2", 0);
        } finally {
            lock.unlock();
        }

        ActivityUtils.doActivity(Thread.currentThread().getName() + " - A3", 0);
    }
}
