package edu.tucn.str.lecture1.ex3withoutPolymorphism;

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

        switch (choice){
            case "1" -> {
                Dacia dacia = new Dacia();
                dacia.start();
                dacia.go();
                dacia.stop();
            }
            case "2" -> {
                BMW bmw = new BMW();
                bmw.start();
                bmw.go();
                bmw.stop();
            }
        }
    }
}
