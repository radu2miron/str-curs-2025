package edu.tucn.str.lecture2.ex2runnable;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Main {
    public static void main(String[] args) {
        FileWriterThread fwt1 = new FileWriterThread("Ioan");
        FileWriterThread fwt2 = new FileWriterThread("Gheorghe");
        FileWriterThread fwt3 = new FileWriterThread("Vasile");
        fwt1.start();
        fwt2.start();
        fwt3.start();
    }
}
