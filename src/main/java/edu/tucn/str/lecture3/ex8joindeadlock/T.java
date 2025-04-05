package edu.tucn.str.lecture3.ex8joindeadlock;

/**
 * @author Radu Miron
 * @version 1
 */
public class T extends Thread {
    private Thread t;

    public T(Thread t) {
        this.t = t;
    }

    public void run() {
        try {
            if (t != null) {
                t.join();
            }
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName() + " finished its execution!");
    }

    public void setT(T t) {
        this.t = t;
    }
}
