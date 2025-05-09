package edu.tucn.str.lecture5.ex5virtualthreads.ex2creation;

import edu.tucn.str.lecture5.ex5virtualthreads.util.Utils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex3CreateVT {
    public static void main(String[] args) throws InterruptedException {
        // create and start create 2 virtual threads
        List<Thread> virtualThreads =
                IntStream.range(0, 5)
                        .mapToObj(i -> Thread.ofVirtual().unstarted(Utils::print10Messages))
                        .peek(Thread::start)
                        .toList();

        virtualThreads.forEach(t -> {
            try {
                t.join(); // join threads
            } catch (InterruptedException e) {
            }
        });
    }
}
