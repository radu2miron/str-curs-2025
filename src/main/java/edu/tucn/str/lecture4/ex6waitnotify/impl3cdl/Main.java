package edu.tucn.str.lecture4.ex6waitnotify.impl3cdl;

import java.util.concurrent.CountDownLatch;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    static final CountDownLatch cdl = new CountDownLatch(1);

    public static void main(String[] args) {
        new NotifierThread().start();
        new WaiterThread().start();
    }
}
