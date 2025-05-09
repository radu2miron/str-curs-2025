package edu.tucn.str.lecture5.ex5virtualthreads.ex1thread_vs_virtualthread;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex1VirtualThreads {
    public static void main(String[] args) {
        List<Thread> virtualThreads = new ArrayList<>();
        for (int i = 0; i < 2_000_000; i++) { // create and start 1.000.000 threads
            virtualThreads.add(Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(10L));
                } catch (InterruptedException e) {
                }
            }));
        }

        // todo: uncomment
        virtualThreads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException ignore) {
            }
        });
    }
}
