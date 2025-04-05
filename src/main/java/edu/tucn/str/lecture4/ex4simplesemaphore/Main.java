package edu.tucn.str.lecture4.ex4simplesemaphore;

import java.util.concurrent.Semaphore;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        new ThreadSemaphore(semaphore).start();
        new ThreadSemaphore(semaphore).start();
        new ThreadSemaphore(semaphore).start();
    }
}
