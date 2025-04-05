package edu.tucn.str.lecture4.ex2_1prodcons;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class ConsumerThread extends Thread {
    private ArrayBlockingQueue<String> queue;

    public ConsumerThread(ArrayBlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String txt = queue.take();
                System.out.printf("%s (txt: %s) - size %d",
                        Thread.currentThread().getName(),
                        txt,
                        txt.length());
            } catch (InterruptedException e) {
            }
        }
    }
}
