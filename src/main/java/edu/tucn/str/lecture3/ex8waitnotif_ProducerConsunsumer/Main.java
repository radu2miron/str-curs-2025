package edu.tucn.str.lecture3.ex8waitnotif_ProducerConsunsumer;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();

        new Producer(monitor).start();
        new Consumer(monitor).start();
    }
}
