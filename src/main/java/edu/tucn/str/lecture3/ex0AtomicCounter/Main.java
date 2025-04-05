package edu.tucn.str.lecture3.ex0AtomicCounter;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        new MyThread(counter).start();
        new MyThread(counter).start();
        new MyThread(counter).start();

        Thread.sleep(1000);

        System.out.println(counter.getValue());
    }
}
