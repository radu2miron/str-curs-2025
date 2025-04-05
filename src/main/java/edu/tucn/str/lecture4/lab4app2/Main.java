package edu.tucn.str.lecture4.lab4app2;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Object p9 = new Object();
        Object p10 = new Object();
        new LeftRightThread(p9, Utils.LEFT).start();
        new MiddleThread(p9, p10, Utils.MIDDLE).start();
        new LeftRightThread(p10, Utils.RIGHT).start();
    }
}
