package edu.tucn.str.lecture4.ex6waitnotify.impl2sem;

/**
 * @author Radu Miron
 * @version 1
 */
public class WaiterThread extends Thread {
    public void run() {
        try {
            Main.semaphore.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println("I was notified");
    }
}