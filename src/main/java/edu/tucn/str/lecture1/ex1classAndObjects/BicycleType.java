package edu.tucn.str.lecture1.ex1classAndObjects;

/**
 * @author Radu Miron
 * @version 1
 */
public enum BicycleType {
    MOUNTAIN_BIKE("mountain bike"),
    CITY_BIKE("city bike"),
    ELECTRIC_BIKE("electric bike"),
    HYBRID_BIKE("hybrid bike");

    private String value;

    BicycleType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
