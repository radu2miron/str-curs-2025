package edu.tucn.str.lecture1.ex5collections.ex2set;

import edu.tucn.str.lecture1.ex1classAndObjects.Bicycle;
import edu.tucn.str.lecture1.ex1classAndObjects.BicycleType;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Radu Miron
 * @version 1
 */
public class MainLinkedHashSet {
    public static void main(String[] args) {
        Set<Bicycle> bicycles = new LinkedHashSet<>();

        bicycles.add(new Bicycle(BicycleType.CITY_BIKE, 44, "blue"));
        bicycles.add(new Bicycle(BicycleType.CITY_BIKE, 12, "blue"));
        bicycles.add(new Bicycle(BicycleType.MOUNTAIN_BIKE, 13, "black"));
        bicycles.add(new Bicycle(BicycleType.ELECTRIC_BIKE, 14, "green"));
        bicycles.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicycles.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicycles.add(new Bicycle(BicycleType.HYBRID_BIKE, 16, "red"));

        bicycles.forEach(System.out::println);
    }
}
