package edu.tucn.str.lecture2.ex4interrupted;

import java.io.IOException;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class ExchangeRateGetterThread extends Thread {
    public boolean interrupted = false;

    public ExchangeRateGetterThread() {
        this.setName("ExchangeRateGetterThread");
    }

    public void run() {
        System.out.println(this.getName() + " started!");
        while (!interrupted) {
            try {
                Thread.sleep(1000);
                System.out.println(ExchageRateReader.getExchangeRates());
                Thread.sleep(24 * 60 * 60 * 1000);
            } catch (InterruptedException e) {
                System.out.println(this.getName() + " interrupted!");
                interrupted = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
