package edu.tucn.str.lecture4.ex6waitnotify.impl1waitnotify;

/**
 * @author Radu Miron
 * @version 1
 */
public class WaiterThread extends Thread {
    public void run() {
        synchronized (Main.monitor){
            try {
                Main.monitor.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("I was notified");
        }
    }
}