package edu.tucn.str.lecture3.ex6deadlock;

/**
 * @author Radu Miron
 * @version 1
 */
public class DeadlockedThread extends Thread {
    private Object l1;
    private Object l2;

    public DeadlockedThread(Object l1, Object l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");

        synchronized (l1) {
            System.out.println(Thread.currentThread().getName() + " got the first lock");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            synchronized (l2) {
                System.out.println(Thread.currentThread().getName() + " got the secod lock");
                System.out.println(Thread.currentThread().getName() + " do the activity");
            }
        }

        System.out.println(Thread.currentThread().getName() + " ended");
    }
}
