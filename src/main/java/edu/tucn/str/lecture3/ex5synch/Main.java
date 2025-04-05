package edu.tucn.str.lecture3.ex5synch;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        new DataIngestionThread(lock).start();
        new DataIngestionThread(lock).start();
    }
}
