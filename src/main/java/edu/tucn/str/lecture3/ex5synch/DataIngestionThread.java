package edu.tucn.str.lecture3.ex5synch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class DataIngestionThread extends Thread {
    public boolean stop = false;
    public Object lock;

    public DataIngestionThread() {
    }

    public DataIngestionThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                //read file
                File readFile = FileUtilities.nextFile();
                List<String> readLines = FileUtilities.readFile(readFile);

                if (readLines != null) {
                    List<String> lines = new ArrayList<>();
                    lines.add(Thread.currentThread().getName());
                    lines.addAll(readLines);
                    lines.add("");
                    //---mutual exclusion
                    synchronized (lock) {
                        //write to aggregated file
                        File aggregatorFile = FileUtilities.getAggregatorFile();
                        FileUtilities.writeLinesToFile(lines, aggregatorFile);
                    }
                    //---end mutual exclusion
                    //delete initial file
                    FileUtilities.deleteFile(readFile);
                }

                Thread.sleep(2500);
            } catch (Exception e) {
                // TODO: TBD
                throw new RuntimeException(e);
            }
        }
    }

    public void doStop() {
        stop = true;
    }
}
