package edu.tucn.str.lecture1.ex5collections.ex2set;

import edu.tucn.str.lecture1.ex1classAndObjects.Bicycle;
import edu.tucn.str.lecture1.ex1classAndObjects.BicycleType;

import java.util.HashSet;
import java.util.Set;

/**
 * HashMap does not guarantee any order.
 *
 * @author Radu Miron
 * @version 1
 */
public class MainHashSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(4);
        set.add(4);
        set.add(5);
        set.add(3);
        set.add(4);
        set.add(4);
        set.add(4);
        set.add(5);

        set.forEach(System.out::println);

        Set<Bicycle> bicycles = new HashSet<>();
        bicycles.add(new Bicycle(BicycleType.CITY_BIKE, 12, "blue"));
        bicycles.add(new Bicycle(BicycleType.MOUNTAIN_BIKE, 13, "black"));
        bicycles.add(new Bicycle(BicycleType.ELECTRIC_BIKE, 14, "green"));
        bicycles.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicycles.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicycles.add(new Bicycle(BicycleType.HYBRID_BIKE, 16, "red"));

        bicycles.forEach(System.out::println);
    }
}
