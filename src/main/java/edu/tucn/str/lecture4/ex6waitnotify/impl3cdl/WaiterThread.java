package edu.tucn.str.lecture4.ex6waitnotify.impl3cdl;

/**
 * @author Radu Miron
 * @version 1
 */
public class WaiterThread extends Thread {
    public void run() {
        try {
            Main.cdl.await(); // this acts as a wait
        } catch (InterruptedException e) {
        }
        System.out.println("I was notified");
    }
}