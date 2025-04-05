package edu.tucn.str.lecture4.ex2_1prodcons;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(5000);
        new ProducerThread(arrayBlockingQueue, "Producer-1").start();
        new ConsumerThread(arrayBlockingQueue, "Consumer-1").start();
        new ConsumerThread(arrayBlockingQueue, "Consumer-2").start();
        new ConsumerThread(arrayBlockingQueue, "Consumer-3").start();
    }
}
