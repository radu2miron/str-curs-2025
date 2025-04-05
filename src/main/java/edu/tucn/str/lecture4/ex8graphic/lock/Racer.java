package edu.tucn.str.lecture4.ex8graphic.lock;

import java.awt.*;
import java.util.concurrent.locks.Lock;

public class Racer extends Component implements Runnable {
    private Lock lock;
    private long time;

    public Racer(Lock lock, long time) {
        this.lock = lock;
        this.time = time;
    }

    @Override
    public void run() {
        while (true) {
            this.setBounds(this.getX(), this.getY() + 5, this.getWidth(), this.getHeight());

            try {
                Thread.sleep(time);

                if (this.getY() == 160) {
                    lock.lock();
                }

                if (this.getY() == 220) {
                    lock.unlock();
                }

                if (this.getY() > 280) {
                    this.setBounds(this.getX(), 0, this.getWidth(), this.getHeight());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(0, 0, 20, 20);
    }

    public void start() {
        new Thread(this).start();
    }
}
