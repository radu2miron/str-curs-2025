package edu.tucn.str.lecture3.ex8joindeadlock;

/**
 * @author Radu Miron
 * @version 1
 */
public class JoinDeadlockMain {
    public static void main(String[] args) {
        T t1 = new T(null);
        T t2 = new T(t1);
        t1.setT(t2);

        t1.start();
        t2.start();
    }
}
