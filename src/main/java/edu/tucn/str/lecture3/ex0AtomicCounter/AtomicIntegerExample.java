package edu.tucn.str.lecture3.ex0AtomicCounter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.incrementAndGet();
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.incrementAndGet();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + counter.get());
    }
}
