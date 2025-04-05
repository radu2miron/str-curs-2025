package edu.tucn.str.lecture3.ex7join;

/**
 * @author Radu Miron
 * @version 1
 */
public class T extends Thread {
    private Thread t;

    public T(Thread t) {
        this.t = t;
    }

    public void run() {
        try {
            if (t != null) { // t2 has a reference to t1 and will do join
                t.join();
            } else { // t1 has no t reference and will sleep for 5 sec
                System.out.println("wait 5 sec");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName() + " finished its execution!");
    }

    public void setT(T t) {
        this.t = t;
    }
}
