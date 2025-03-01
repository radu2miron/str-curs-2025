package edu.tucn.str.lecture1.ex5collections.ex1list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(5);
        list.add(3);
        list.add(4);

        System.out.println("Initial list: ");
        list.forEach(System.out::println);  // list.forEach(i -> System.out.println(i));

        Collections.sort(list); // sort the list

        System.out.println("Sorted list: ");
        list.forEach(System.out::println);

    }
}
