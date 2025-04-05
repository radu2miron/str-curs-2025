package edu.tucn.str.lecture3.ex0AtomicCounter;

/**
 * @author Radu Miron
 * @version 1
 */
public class Counter {
    private int value;

    public void increment() {
        value += 1;
    }

    public int getValue() {
        return value;
    }
}
