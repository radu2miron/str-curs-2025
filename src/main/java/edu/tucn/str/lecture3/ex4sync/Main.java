package edu.tucn.str.lecture3.ex4sync;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }
}
