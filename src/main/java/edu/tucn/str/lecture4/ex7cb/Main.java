package edu.tucn.str.lecture4.ex7cb;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new ThreadCB(cyclicBarrier, 500).start();
        new ThreadCB(cyclicBarrier, 2000).start();
        new ThreadCB(cyclicBarrier, 5000).start();
    }
}
