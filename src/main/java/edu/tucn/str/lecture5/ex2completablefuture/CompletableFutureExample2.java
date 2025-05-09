package edu.tucn.str.lecture5.ex2completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author Radu Miron
 * @version 1
 */
public class CompletableFutureExample2 {
    public static void main(String[] args) {
        // simulate fetching data from a web service asynchronously
        CompletableFuture<String> webServiceFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("1. " + Thread.currentThread());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

            return "Hello from web service!";
        });

        // simulate fetching data from a database asynchronously
        CompletableFuture<Integer> databaseFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("2. " + Thread.currentThread());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }

            return 10;
        });

        // combine the results of the two futures when they both complete
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(webServiceFuture, databaseFuture);

        // calculate the sum of the total length of the string and the integer value when both futures are complete
        combinedFuture.thenRun(() -> {
            String resultFromWebService = webServiceFuture.join();
            Integer resultFromDatabase = databaseFuture.join();
            int totalLength = resultFromWebService.length() + resultFromDatabase;
            System.out.println("3. " + Thread.currentThread());
            System.out.println("Total length: " + totalLength);
        });

        // wait for all tasks to complete
        combinedFuture.join();
    }
}
