package edu.tucn.str.lecture5.ex5virtualthreads.ex2creation;

import edu.tucn.str.lecture5.ex5virtualthreads.util.Utils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex1CreateVT {
    public static void main(String[] args) {
        // create virtual thread task
        Runnable virtualThreadTask = new Runnable() {
            @Override
            public void run() {
                Utils.print10Messages();
            }
        }; // it can be replaced with: () -> Utils.print10Messages()

        // create and start 5 virtual threads
        List<Thread> virtualThreads = IntStream.range(0, 5)
                .mapToObj(i -> Thread.startVirtualThread(virtualThreadTask))
                .toList();

        virtualThreads.forEach(t -> {
            try {
                t.join(); // virtual threads are always daemon threads
                          // we need to call join(), otherwise the application will close before printing anything
            } catch (InterruptedException e) {
            }
        });
    }
}
