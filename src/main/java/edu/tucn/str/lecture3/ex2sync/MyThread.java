package edu.tucn.str.lecture3.ex2sync;

/**
 * @author Radu Miron
 * @version 1
 */
public class MyThread extends Thread {
    private static final Object l = new Object();

    @Override
    public void run() {
        new Activity(1).execute();

        synchronized (l) { //regiune critica
            //excludere reciproca (mutual)
            new Activity(2).execute();
        }//.end regiune critica

        new Activity(3).execute();
    }

    class Activity {
        private int id;

        public Activity(int id) {
            this.id = id;
        }

        public void execute() {
            System.out.println(
                    String.format("%s executes activity %d", Thread.currentThread(), id));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
