package edu.tucn.str.lecture4.ex6waitnotify.impl3cdl;

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
            Main.cdl.countDown(); // this acts as a notify
        } catch (InterruptedException e) {
        }
    }
}