package edu.tucn.str.lecture5.ex1executorfuture;

import java.util.concurrent.Callable;

/**
 * @author Radu Miron
 * @version 1
 */
public class MyCallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Simulate some time-consuming task
        Thread.sleep(2000);

        return "Task completed by " + Thread.currentThread().getName();
    }
}