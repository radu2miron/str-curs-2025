package edu.tucn.str.lecture1.ex4polymorphism;

import java.util.Scanner;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input: 1. Dacia, 2. BMW, 3. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        Car car = null;

        switch (choice) {
            case "1" -> car = new Dacia("Dacia");
            case "2" -> car = new BMW("BMW");
            default -> System.exit(0);
        }

        car.start();
        car.go();
        car.stop();
    }
}
