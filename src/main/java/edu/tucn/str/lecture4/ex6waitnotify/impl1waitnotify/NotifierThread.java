package edu.tucn.str.lecture4.ex6waitnotify.impl1waitnotify;

/**
 * @author Radu Miron
 * @version 1
 */
public class NotifierThread extends Thread {
    public void run() {
        try {
            System.out.println("Lets make the waiter wait");
            Thread.sleep(2000);
            synchronized (Main.monitor) { // uses the same instance
                Main.monitor.notify();
                System.out.println("The waiter will wait for the next sleep. " +
                        "I'm still holding the lock (still in 'synchronized')");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {}
    }
}