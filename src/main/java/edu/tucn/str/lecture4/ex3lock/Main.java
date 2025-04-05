package edu.tucn.str.lecture4.ex3lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new ThreadLock(lock).start();
        new ThreadLock(lock).start();
    }
}
