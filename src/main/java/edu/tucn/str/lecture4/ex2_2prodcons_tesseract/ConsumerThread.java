package edu.tucn.str.lecture4.ex2_2prodcons_tesseract;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class ConsumerThread extends Thread {
    private final JTextArea logArea;
    private ArrayBlockingQueue<File> queue;
    private static final String TXT_DIR = "lecture_files/lecture4/";

    public ConsumerThread(ArrayBlockingQueue<File> queue, String name, JTextArea logArea) {
        this.queue = queue;
        this.setName(name);
        this.logArea = logArea;
    }

    @Override
    public void run() {
        while (true) {
            try {
                File imgFile = queue.take();
                String txt = TessUtils.readText(imgFile);
                Path txtPath = Paths.get(TXT_DIR + imgFile.getName().replace(".png", ".txt"));
                Files.writeString(txtPath, txt);
                logArea.append(Thread.currentThread().getName() + " extracted text to " + txtPath.toFile().getName() + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
