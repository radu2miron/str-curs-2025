package edu.tucn.str.lecture1.ex5collections.ex2set;

import edu.tucn.str.lecture1.ex1classAndObjects.Bicycle;
import edu.tucn.str.lecture1.ex1classAndObjects.BicycleType;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Radu Miron
 * @version 1
 */
public class MainTreeSet {
    public static void main(String[] args) {
        Set<Bicycle> bicyclesSortedByColor = new TreeSet<>(
                (bicycle1, bicycle2) -> bicycle1.getColor().compareTo(bicycle2.getColor()));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.CITY_BIKE, 12, "blue"));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.CITY_BIKE, 25, "magenta"));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.MOUNTAIN_BIKE, 13, "black"));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.ELECTRIC_BIKE, 14, "green"));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicyclesSortedByColor.add(new Bicycle(BicycleType.HYBRID_BIKE, 16, "red"));

        bicyclesSortedByColor.forEach(System.out::println);
//        System.out.println(bicycles);
        System.out.println();
        System.out.println("-----------------------------------------------");
        Set<Bicycle> bicyclesSortedByGears = new TreeSet<>();
        bicyclesSortedByGears.add(new Bicycle(BicycleType.CITY_BIKE, 12, "blue"));
        bicyclesSortedByGears.add(new Bicycle(BicycleType.CITY_BIKE, 25, "magenta"));
        bicyclesSortedByGears.add(new Bicycle(BicycleType.MOUNTAIN_BIKE, 13, "black"));
        bicyclesSortedByGears.add(new Bicycle(BicycleType.ELECTRIC_BIKE, 14, "green"));
        bicyclesSortedByGears.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicyclesSortedByGears.add(new Bicycle(BicycleType.HYBRID_BIKE, 15, "red"));
        bicyclesSortedByGears.add(new Bicycle(BicycleType.HYBRID_BIKE, 16, "red"));

        bicyclesSortedByGears.forEach(System.out::println);
    }
}
