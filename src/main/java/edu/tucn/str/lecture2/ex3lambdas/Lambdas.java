package edu.tucn.str.lecture2.ex3lambdas;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

// it has nothing to do with threads
public class Lambdas {
    public static void main(String[] args) {
        String names =
                Arrays.asList("Ioan", "John", "Ivan", "Janos", "Jovani").stream()
                        .filter(x -> x.startsWith("I"))
                        .map(x -> x.toUpperCase())
                        .collect(Collectors.joining("_"));

        System.out.println(names);
    }
}
