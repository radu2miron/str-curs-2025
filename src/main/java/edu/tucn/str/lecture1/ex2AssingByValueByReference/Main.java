package edu.tucn.str.lecture1.ex2AssingByValueByReference;

import edu.tucn.str.lecture1.ex1classAndObjects.Bicycle;
import edu.tucn.str.lecture1.ex1classAndObjects.BicycleType;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        // Case 1: assignment by reference
        Bicycle b1 = new Bicycle(BicycleType.HYBRID_BIKE, 18, "green");
        Bicycle b2 = b1;

        b1.setGears(20);

        System.out.println(b2);
        System.out.printf("We've created %d bike(s)\n", Bicycle.getCounter());

        // Case 2 assignment by value
        int a = 5;
        int b = a;
        a++;
        System.out.println(b);
    }
}