package edu.tucn.str.lecture5.ex5virtualthreads.util;

/**
 * @author Radu Miron
 * @version 1
 */
public class Utils {
    public static void print10Messages(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + " -> Msg. num.  " + i);
        }
    }
}
