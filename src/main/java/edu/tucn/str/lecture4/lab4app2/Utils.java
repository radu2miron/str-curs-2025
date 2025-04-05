package edu.tucn.str.lecture4.lab4app2;

/**
 * @author Radu Miron
 * @version 1
 */
public class Utils {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String MIDDLE = "middle";

    public static int getRandomK(int min, int max) {
        return (int) Math.round(Math.random() * (max - min) + min);

    }
}
