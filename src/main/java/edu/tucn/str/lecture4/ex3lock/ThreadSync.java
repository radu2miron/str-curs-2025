package edu.tucn.str.lecture4.ex3lock;

import edu.tucn.str.lecture4.util.ActivityUtils;

/**
 * @author Radu Miron
 * @version 1
 */
public class ThreadSync extends Thread {

    public void run() {
        ActivityUtils.doActivity(Thread.currentThread().getName() + " - A1", 0);

        synchronized (ThreadSync.class) {
            ActivityUtils.doActivity(Thread.currentThread().getName() + " - A2", 0);
        }

        //OR
        //ActivityUtils.doSyncActivity(Thread.currentThread().getName() + " - A2", 0);

        ActivityUtils.doActivity(Thread.currentThread().getName() + " - A3", 0);
    }
}
