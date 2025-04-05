package edu.tucn.str.lecture4.lab4app2;

import edu.tucn.str.lecture4.util.ActivityUtils;

/**
 * @author Radu Miron
 * @version 1
 */
public class MiddleThread extends Thread {
    private Object lock1;
    private Object lock2;

    public MiddleThread(Object lock1, Object lock2, String name) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.setName(name);
    }

    @Override
    public void run() {
        ActivityUtils.doActivity("P11", 0);

        synchronized (lock1) {
            synchronized (lock2) { // both synch represent T11
                ActivityUtils.doActivity("12", Utils.getRandomK(3, 6));
            }
        } // last two '}' represent T12

        ActivityUtils.doActivity("P13", 0);
    }
}
