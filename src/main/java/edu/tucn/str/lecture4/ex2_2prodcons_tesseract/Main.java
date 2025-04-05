package edu.tucn.str.lecture4.ex2_2prodcons_tesseract;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<File> arrayBlockingQueue = new ArrayBlockingQueue<>(5000);
        Win win = new Win(arrayBlockingQueue);
        new ConsumerThread(arrayBlockingQueue, "Consumer-1", win.getLogArea()).start();
        new ConsumerThread(arrayBlockingQueue, "Consumer-2", win.getLogArea()).start();
    }
}
