package edu.tucn.str.lecture5.ex1executorfuture;

/**
 * @author Radu Miron
 * @version 1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();

        // Create an ExecutorService with a fixed-size thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // List to store Future objects
        List<Future<String>> futureResults = new ArrayList<>();

        // Submit multiple tasks
        for (int i = 1; i <= 5; i++) {
            Future<String> future = executorService.submit(new MyCallableTask());
            futureResults.add(future);
        }

        // Do other work while tasks are running asynchronously

        // Retrieve results from Future objects
        for (Future<String> future : futureResults) {
            try {
                // Blocking call to get the result of each task
                String result = future.get();
                System.out.println("Task result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor when done
        executorService.shutdown();

        long t2 = System.currentTimeMillis();
        System.out.println("Time: " + (t2 - t1) / 1000 + " sec.");
    }
}

