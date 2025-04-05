package edu.tucn.str.lecture4.ex6waitnotify.impl2sem;

/**
 * @author Radu Miron
 * @version 1
 */
public class NotifierThread extends Thread {
    public void run() {
        try {
            System.out.println("Lets make the waiter wait");
            Thread.sleep(2000);
            System.out.println("I'm notifying the waiter right now");
            Main.semaphore.release();
        } catch (InterruptedException e) {
        }
    }
}