package edu.tucn.str.lecture4.ex5cdl;

import java.util.concurrent.CountDownLatch;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new ThreadCDL(countDownLatch, 500).start();
        new ThreadCDL(countDownLatch, 2000).start();
        new ThreadCDL(countDownLatch, 5000).start();
    }
}
