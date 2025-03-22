package edu.tucn.str.lecture2.ex1thread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class FileWriterThread extends Thread {
    private static final File FILE = new File("lecture_files/lecture_1_ex1.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public FileWriterThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        IntStream.range(0, 1000)
                .forEach(i -> {
                    try {
                        FileUtils.writeStringToFile(
                                FILE,
                                String.format("%s - [%s] - message number %d\n",LocalDateTime.now().format(FORMATTER),
                                        Thread.currentThread().getName(), i),
                                true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
