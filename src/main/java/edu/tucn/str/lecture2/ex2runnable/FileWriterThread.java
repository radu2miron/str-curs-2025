package edu.tucn.str.lecture2.ex2runnable;


import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class FileWriterThread extends FileWriter implements Runnable {
    private static final File FILE = new File("lecture_files/lecture_1_ex1.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String name;

    public FileWriterThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        IntStream.range(0, 1000)
                .forEach(i -> writeToFile(
                                        FILE,
                                        String.format("%s - [%s] - message number %d %n", LocalDateTime.now().format(FORMATTER),
                                            Thread.currentThread().getName(), i),
                                true));
    }

    //this is our method start(); it has nothing to do with Thread - start()
    public void start() {
        Thread t = new Thread(this);
        t.setName(this.name);
        t.start();
    }
}
