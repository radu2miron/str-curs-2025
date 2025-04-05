package edu.tucn.str.lecture3.ex7join;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        T t1 = new T(null);
        T t2 = new T(t1);

        t1.start();
        t2.start();
    }
}
