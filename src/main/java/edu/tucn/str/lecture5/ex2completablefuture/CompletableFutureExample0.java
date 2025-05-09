package edu.tucn.str.lecture5.ex2completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author Radu Miron
 * @version 1
 */
public class CompletableFutureExample0 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CompletableFuture.supplyAsync(() -> new Random().nextInt(100)) // execute async
                    .thenApply(r -> r * 3) // transform the result
                    .thenApply(r -> "<" + r + ">") // transform the result
                    .thenAccept(System.out::println) // print the result
                    .join(); // wait for the final result and return it
        }
    }
}
