package edu.tucn.str.lecture4.ex6waitnotify.impl2sem;

import java.util.concurrent.Semaphore;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    static final Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {
        new NotifierThread().start();
        new WaiterThread().start();
    }
}
