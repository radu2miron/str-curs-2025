package edu.tucn.str.lecture4.ex2concurrentmodifexc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("c");
//        list.add("des");
//        list.add("e");
//        list.add("des");
//
//        for (String s : list) { // throws exception
//            if (s.equals("des")) {
//                list.remove(s);
//            }
//        }
//
//        Iterator<String> iterator = list.iterator(); // good alternative
//        while (iterator.hasNext()) {
//            String currentString = iterator.next();
//            if (currentString.equals("des")) {
//                iterator.remove();
//            }
//        }
//
//        System.out.println(list.size());

        List<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("a");
        list1.add("c");
        list1.add("des");
        list1.add("e");
        list1.add("des");

        for (String s : list1) { // not throws exception
            if (s.equals("des")) {
                list1.remove(s);
            }
        }

        System.out.println(list1.size());

    }
}
