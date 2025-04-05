package edu.tucn.str.lecture3.ex8waitnotif_ProducerConsunsumer;

import java.io.IOException;
import java.util.Map;

/**
 * @author Radu Miron
 * @version 1
 */
public class Consumer extends Thread {
    private Object monitor;

    public Consumer(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            try {
                monitor.wait(); // wait for the notification from the producer
            } catch (InterruptedException ignored) {
            }
        }

        try {
            Map<Character, Integer> results = FileUtilities.processFile();
            printResults(results);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printResults(Map<Character, Integer> results) {
        results.forEach((k, v) -> System.out.println(k + "->" + v));
    }
}
