package edu.tucn.str.lecture3.ex1sync;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Object l = new Object();
        new MyThread(l).start();
        new MyThread(l).start();
    }
}
