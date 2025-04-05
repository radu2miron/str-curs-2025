package edu.tucn.str.lecture4.ex1singleton;

/**
 * @author Radu Miron
 * @version 1
 */
public class Singleton {
    public volatile static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}
