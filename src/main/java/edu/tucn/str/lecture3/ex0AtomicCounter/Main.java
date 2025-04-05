package edu.tucn.str.lecture3.ex0AtomicCounter;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);
        Thread t3 = new MyThread(counter);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(counter.getValue());
    }
}
