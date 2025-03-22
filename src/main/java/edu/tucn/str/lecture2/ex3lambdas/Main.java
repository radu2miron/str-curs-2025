package edu.tucn.str.lecture2.ex3lambdas;

import java.util.stream.IntStream;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Main {
    public static void main(String[] args) {
        // a thread implemented as a anonymous class based on Runnable
        Runnable runnable = new Runnable() {
            public void run() {
                writeMessages();
            }
        };
        new Thread(runnable).start();

        // a thread implemented as a lambda expression
        new Thread(() -> writeMessages()).start();
    }

    public static void writeMessages(){
        IntStream.range(0, 1000).forEach(i -> {
            System.out.println(Thread.currentThread().getName() + "- message: " + i);
        });
    }
}
