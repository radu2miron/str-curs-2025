package edu.tucn.str.lecture4.ex6waitnotify.impl1waitnotify;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    static final Object monitor = new Object();
    public static void main(String[] args) {
        new NotifierThread().start();
        new WaiterThread().start();
    }
}
