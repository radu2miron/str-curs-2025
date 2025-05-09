package edu.tucn.str.lecture5.ex5virtualthreads.ex1thread_vs_virtualthread;

import java.time.Duration;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex1Threads {
    public static void main(String[] args) {
        for (int i = 0; i < 100_000; i++) { // create and start 100.000 threads
            new Thread(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(10L));
                } catch (InterruptedException e) {
                }
            }).start();
        }
    }
}
