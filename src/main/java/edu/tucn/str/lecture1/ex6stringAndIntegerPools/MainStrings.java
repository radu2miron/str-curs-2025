package edu.tucn.str.lecture1.ex6stringAndIntegerPools;

import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class MainStrings {
    public static void main(String[] args) throws InterruptedException {
        String s1 = "Hello";
        String s2 = "Hello";

        System.out.println("Please enter 'Hello':");

        Scanner scanner = new Scanner(System.in);
        String s3 = scanner.nextLine();
        System.out.println("|"+s3+"|");

        // TODO: please remeber that Strings should not be compared with '=='. Use 'equals()' instead.
        System.out.println("s1==s2? " + (s1 == s2)); // this is true because of String literals caching.
        System.out.println("s1==s3? " + (s1 == s3)); // this is not true because the new 'Hello' value (s3)
                                                     // ... is input from the outside, so it is not the same literal.
    }
}
