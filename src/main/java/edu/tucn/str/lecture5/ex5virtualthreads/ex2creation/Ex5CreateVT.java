package edu.tucn.str.lecture5.ex5virtualthreads.ex2creation;

import edu.tucn.str.lecture5.ex5virtualthreads.util.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex5CreateVT { // FIRE AND FORGET EXAMPLE
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory vtThreadFactory = Thread.ofVirtual().factory();
        ExecutorService vtExecutor = Executors.newThreadPerTaskExecutor(vtThreadFactory);

        IntStream.range(0, 10)
                .forEach(i -> vtExecutor.execute(
                        //this is a Runnable implementation
                        () -> Utils.print10Messages()));

        vtExecutor.awaitTermination(1, TimeUnit.SECONDS); // we need to wait for virtual threads, they are daemons
    }
}
