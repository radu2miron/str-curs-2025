package edu.tucn.str.lecture5.ex2completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author Radu Miron
 * @version 1
 */
public class CompletableFutureExample1 {
    public static void main(String[] args) {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            // simulate a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // simulate an error
            if (new Random().nextInt(2) % 2 == 0) {
                throw new RuntimeException("Simulated exception");
            }

            // print current thread
            System.out.println("1. " + Thread.currentThread());

            return new Random().nextInt(100);
        });

        completableFuture.thenApply(result -> {
                    System.out.println("2. " + Thread.currentThread());
                    return result * 2;
                })
                .thenAccept(result -> {
                    System.out.println("3. " + Thread.currentThread());
                    System.out.println("Result: " + result);
                })
                .exceptionally(ex -> {
                    System.err.println("Exception occurred: " + ex.getMessage());
                    return null;
                })
                .join();
    }
}
