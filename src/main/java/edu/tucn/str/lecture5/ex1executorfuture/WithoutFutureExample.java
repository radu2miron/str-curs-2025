package edu.tucn.str.lecture5.ex1executorfuture;

/**
 * @author Radu Miron
 * @version 1
 */
public class WithoutFutureExample {
    public static void main(String[] args) throws Exception {
        long t1 = System.currentTimeMillis();

        for (int i = 1; i <= 5; i++) {
            MyCallableTask myCallableTask = new MyCallableTask();
            System.out.println("Task result: " + myCallableTask.call());
        }

        long t2 = System.currentTimeMillis();

        System.out.println("Time: " + (t2 - t1) / 1000 + " sec.");
    }
}
