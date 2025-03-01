package edu.tucn.str.lecture1.ex1classAndObjects;

import java.util.Objects;

/**
 * @author Radu Miron
 * @version 1
 */
public class Bicycle implements Comparable<Bicycle>{
    private static int counter = 0;
    private BicycleType bicycleType;
    private int gears;
    private String color;

    public Bicycle(BicycleType bicycleType, int gears, String color) {
        this.bicycleType = bicycleType;
        this.gears = gears;
        this.color = color;
        counter++;
    }

    public void bend() {
        System.out.printf("The %s bike bends\n", this.color);
    }

    public void doBreak() {
        System.out.printf("The %s breaks\n", this.bicycleType);
    }

    public void doAccident(Bicycle other) {
        System.out.printf("The %s bike bumps into %s bike\n", this.color, other.color);
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return gears == bicycle.gears && bicycleType == bicycle.bicycleType && Objects.equals(color, bicycle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bicycleType, gears, color);
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "bicycleType=" + bicycleType +
                ", gears=" + gears +
                ", color='" + color + '\'' +
                '}';
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public int compareTo(Bicycle bicycle) {
        return Integer.valueOf(this.gears).compareTo(Integer.valueOf(bicycle.gears));
    }
}
