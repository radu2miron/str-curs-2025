package edu.tucn.str.lecture5.ex4_completablefuture_api_gui;

/**
 * @author Radu Miron
 * @version 1
 */
public record TemperatureModel(CurrentUnits current_units, Current current) {
}

record Current(float temperature_2m){
}

record CurrentUnits(String temperature_2m){
}
