package edu.tucn.str.lecture5.ex5virtualthreads.ex2creation;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author Radu Miron
 * @version 1
 */
public class Ex4CreateVT { // FORK-JOIN EXAMPLE
    public static void main(String[] args) {
        List<Future<Integer>> futureValues = new ArrayList<>();

        ExecutorService vtExecutor = Executors.newVirtualThreadPerTaskExecutor();

        IntStream.range(0, 10).forEach(i ->
                futureValues.add(
                        vtExecutor.submit(
                                // this is a Callable implementation
                                () -> {
                                    try {
                                        Thread.sleep(1000); // simulate some hard computation
                                    } catch (InterruptedException e) {
                                    }

                                    return new Random().nextInt();
                                }))
        );

        IntSummaryStatistics resultsStatistics =
                futureValues.stream()
                        .map(fv -> {
                            try {
                                return fv.get();
                            } catch (InterruptedException | ExecutionException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .mapToInt(Integer::intValue)
                        .summaryStatistics();

        System.out.println(resultsStatistics);
    }
}
