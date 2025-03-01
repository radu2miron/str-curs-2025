package edu.tucn.str.lecture1.ex5collections.ex3map;

import edu.tucn.str.lecture1.ex1classAndObjects.Bicycle;
import edu.tucn.str.lecture1.ex1classAndObjects.BicycleType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Radu Miron
 * @version 1
 */
public class MainHashMap {
    public static void main(String[] args) {
        Bicycle b1 = new Bicycle(BicycleType.CITY_BIKE, 44, "blue");
        Bicycle b2 = new Bicycle(BicycleType.CITY_BIKE, 12, "blue");
        Bicycle b3 = new Bicycle(BicycleType.MOUNTAIN_BIKE, 13, "black");
        Bicycle b4 = new Bicycle(BicycleType.ELECTRIC_BIKE, 14, "green");
        Bicycle b5 = new Bicycle(BicycleType.HYBRID_BIKE, 15, "red");
        Bicycle b6 = new Bicycle(BicycleType.HYBRID_BIKE, 15, "red");
        Bicycle b7 = new Bicycle(BicycleType.HYBRID_BIKE, 16, "red");

        Map<String, Bicycle> bicycleByColor = new HashMap<>();
        bicycleByColor.put(b1.getColor(), b1);
        bicycleByColor.put(b2.getColor(), b2);
        bicycleByColor.put(b3.getColor(), b3);
        bicycleByColor.put(b4.getColor(), b4);
        bicycleByColor.put(b5.getColor(), b5);
        bicycleByColor.put(b6.getColor(), b6);
        bicycleByColor.put(b7.getColor(), b7);

        bicycleByColor.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println();
        System.out.println(bicycleByColor.get("green"));
        System.out.println(bicycleByColor.get("red"));
    }
}
