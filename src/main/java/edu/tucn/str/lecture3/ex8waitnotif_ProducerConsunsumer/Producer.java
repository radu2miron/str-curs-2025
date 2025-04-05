package edu.tucn.str.lecture3.ex8waitnotif_ProducerConsunsumer;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Radu Miron
 * @version 1
 */
public class Producer extends Thread {
    private Object monitor;

    public Producer(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        String line = "";
        Scanner scanner = new Scanner(System.in);

        while (!line.equals("stop")) {
            System.out.println("Input a line:");
            line = scanner.nextLine();
            try {
                FileUtilities.writeStringToFile(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        synchronized (monitor) {
            monitor.notify(); // notify the consumer
        }
    }
}
