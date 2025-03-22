package edu.tucn.str.lecture2.ex4interrupted;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class Interruptor extends Thread {
    private Thread thread;

    public Interruptor(Thread thread) {
        this.setName("Interruptor");
        this.thread = thread;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        thread.interrupt();
    }
}
