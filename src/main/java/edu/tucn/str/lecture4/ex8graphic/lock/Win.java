package edu.tucn.str.lecture4.ex8graphic.lock;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Win extends JFrame {
    public Win() {
        this.setName("Race");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        Line line1 = new Line();
        line1.setBounds(0, 180, 305, 2);
        this.add(line1);

        Line line2 = new Line();
        line2.setBounds(0, 220, 305, 2);
        this.add(line2);


        LockImage lockImage = new LockImage();
        lockImage.setBounds(3, 178, 36, 45);
        this.add(lockImage);

        Lock lock = new ReentrantLock();
        List<Racer> racerList = Arrays.asList(new Racer(lock, 82), new Racer(lock, 80),
                new Racer(lock, 80), new Racer(lock, 81));

        int xInc = this.getWidth() / (racerList.size() + 1);

        for (int i = 0; i < racerList.size(); i++) {
            Racer racer = racerList.get(i);
            int x = xInc * (i + 1);
            racer.setBounds(x, 10, 20,20);
            this.add(racer);
            racer.start();
        }

        this.setVisible(true);
    }
}
