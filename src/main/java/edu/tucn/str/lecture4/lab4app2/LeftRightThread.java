package edu.tucn.str.lecture4.lab4app2;

import edu.tucn.str.lecture4.util.ActivityUtils;

/**
 * @author Radu Miron
 * @version 1
 */
public class LeftRightThread extends Thread {
    private Object lock;

    public LeftRightThread(Object lock, String name) {
        this.lock = lock;
        this.setName(name);
    }

    @Override
    public void run() {
        ActivityUtils.doActivity(this.getName().equals(Utils.LEFT) ? "P1" : "P2", 0);

        synchronized (lock) { // this is T2 for 'left' and T3 for 'right'
            ActivityUtils.doActivity(this.getName().equals(Utils.LEFT) ? "P4" : "P3",
                    this.getName().equals(Utils.LEFT) ? Utils.getRandomK(2, 4) : Utils.getRandomK(2, 5));
        } // this is T4 for 'left' and T5 for 'right'

        ActivityUtils.doActivity(this.getName().equals(Utils.LEFT) ? "P6" : "P5", 0);
    }
}
