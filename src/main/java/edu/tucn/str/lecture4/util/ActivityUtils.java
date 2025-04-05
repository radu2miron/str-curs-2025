package edu.tucn.str.lecture4.util;

/**
 * @author Radu Miron
 * @version 1
 */
public class ActivityUtils {
    public static void doActivity(String name, int k) {
        System.out.println("executing activity " + name);

        for (int i = 0; i < k; i++) {
            i++;
            i--;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public static synchronized void doSyncActivity(String name, int k) {
        System.out.println("executing activity " + name);

        for (int i = 0; i < k; i++) {
            i++;
            i--;
        }
    }
}
