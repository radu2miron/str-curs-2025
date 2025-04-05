package edu.tucn.str.lecture4.ex7cb1;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
                () -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Start executing the CB's runnable");

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }

                    System.out.println("End executing the CB's runnable");
                });
        new ThreadCB(cyclicBarrier, 5000).start();
        new ThreadCB(cyclicBarrier, 500).start();
        new ThreadCB(cyclicBarrier, 2000).start();
    }
}
