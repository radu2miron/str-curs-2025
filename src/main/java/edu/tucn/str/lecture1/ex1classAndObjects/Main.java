package edu.tucn.str.lecture1.ex1classAndObjects;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        Bicycle bicycle1 = new Bicycle(BicycleType.CITY_BIKE, 12, "red");
        Bicycle bicycle2 = new Bicycle(BicycleType.MOUNTAIN_BIKE, 14, "blue");

        bicycle1.bend();
        bicycle2.doBreak();
        bicycle1.doAccident(bicycle2);
        bicycle2.doAccident(bicycle1);

        System.out.printf("We've created %d bike(s)\n", Bicycle.getCounter());
    }
}
