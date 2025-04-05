package edu.tucn.str.lecture3.ex4sync;

/**
 * @author Radu Miron
 * @version 1
 */
public class MyThread extends Thread {
    private static final Activity activity2 = new Activity(2);

    @Override
    public void run() {
        new Activity(1).execute();

        activity2.executeSynchronized();

        new Activity(3).execute();
    }

    static class Activity {
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

        public synchronized void executeSynchronized() {
            execute();
        }
    }
}
