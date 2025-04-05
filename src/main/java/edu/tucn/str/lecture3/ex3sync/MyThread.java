package edu.tucn.str.lecture3.ex3sync;

/**
 * @author Radu Miron
 * @version 1
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        new Activity(1).execute();

        synchronized (MyThread.class) { //regiune critica
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
                    String.format("%s executes activity %d", Thread.currentThread().getName(), id));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
