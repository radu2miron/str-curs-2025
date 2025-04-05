package edu.tucn.str.lecture3.ex6deadlock;

/**
 * @author Radu Miron
 * @version 1
 */
public class SyncDeadlockMain {
    public static void main(String[] args) {
        Object l1 = new Object();
        Object l2 = new Object();
        new DeadlockedThread(l1, l2).start();
        new DeadlockedThread(l2, l1).start();
    }
}
