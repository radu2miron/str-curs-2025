package edu.tucn.str.lecture4.ex2_1prodcons;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class ProducerThread extends Thread {
    private ArrayBlockingQueue<String> queue;

    public ProducerThread(ArrayBlockingQueue<String> queue, String name) {
        this.setName(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input txt:");
            String txt = scanner.nextLine();
            queue.offer(txt);
        }
    }
}
