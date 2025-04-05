package edu.tucn.str.lecture4.ex2_2prodcons_tesseract;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class ProducerThread extends Thread {
    private ArrayBlockingQueue<File> queue;
    private File imgDirectory;
    private JTextArea logArea;

    public ProducerThread(ArrayBlockingQueue<File> queue, File imgDirectory, JTextArea logArea) {
        this.setName("Producer-1");
        this.queue = queue;
        this.imgDirectory = imgDirectory;
        this.logArea = logArea;
    }

    @Override
    public void run() {
        File[] files = imgDirectory.listFiles();
        Arrays.asList(files).stream()
                .filter(f -> f.getName().toLowerCase().endsWith(".png"))
                .forEach(f -> {
                    queue.offer(f);
                    logArea.append(
                            Thread.currentThread().getName() + "added file for processing " + f.getName() + "\n");
                });
    }
}
