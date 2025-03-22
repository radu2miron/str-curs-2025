package edu.tucn.str.lecture2.ex4interrupted;

import java.io.IOException;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Main {
    public static void main(String[] args) throws IOException {
        ExchangeRateGetterThread rateGetterThread = new ExchangeRateGetterThread();
        rateGetterThread.start();

        new Interruptor(rateGetterThread).start();
    }
}
