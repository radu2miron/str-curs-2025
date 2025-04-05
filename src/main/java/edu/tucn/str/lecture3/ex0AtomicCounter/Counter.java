package edu.tucn.str.lecture3.ex0AtomicCounter;

/**
 * @author Radu Miron
 * @version 1
 */
public class Counter {
    private volatile int value;

    // todo: make increment() synchronized and re-run the program
    public synchronized void increment() {
        value += 1;
    }

    public int getValue() {
        return value;
    }
}
