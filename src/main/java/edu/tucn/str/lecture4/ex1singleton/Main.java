package edu.tucn.str.lecture4.ex1singleton;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();

        //todo: try to break the non-thread safe implementation of the Singleton with multiple threads; maybe try and use ContDownLatch
    }
}
