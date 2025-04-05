package edu.tucn.str.lecture4.ex8graphic.cdl;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Win extends JFrame {
    public Win() {
        this.setName("Race");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        Barrier barrier = new Barrier();
        barrier.setBounds(0, 220, 305, 20);
        this.add(barrier);

        CountDownLatch cdl = new CountDownLatch(3);
        List<Racer> racerList = Arrays.asList(new Racer(cdl, 100), new Racer(cdl, 200), new Racer(cdl, 100));

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
