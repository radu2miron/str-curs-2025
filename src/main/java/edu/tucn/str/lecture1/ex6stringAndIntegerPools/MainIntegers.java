package edu.tucn.str.lecture1.ex6stringAndIntegerPools;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class MainIntegers {
    public static void main(String[] args) {
        Integer i1 = 11;
        Integer i2 = 11;
        System.out.printf("%d==%d? " + (i1 == i2) + "\n", i1, i2);

        Integer i3 = 125;
        Integer i4 = 125;
        System.out.printf("%d==%d? " + (i3 == i4) + "\n", i3, i4);

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.printf("%d==%d? " + (i5 == i6) + "\n", i5, i6);
        System.out.printf("%d==%d? " + (i5.equals(i6)) + "\n", i5, i6);

        //todo: REMEMBER - The reference type Integer should be compared with equals(), as well!
    }
}
