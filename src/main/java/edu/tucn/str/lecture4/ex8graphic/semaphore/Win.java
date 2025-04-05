package edu.tucn.str.lecture4.ex8graphic.semaphore;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Win extends JFrame {
    public Win() {
        this.setName("Race");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        SemaphoreImage semaphoreImage = new SemaphoreImage();
        semaphoreImage.setBounds(3, 150, 32, 77);
        this.add(semaphoreImage);

        Line line1 = new Line();
        line1.setBounds(0, 160, 305, 2);
        this.add(line1);

        Line line2 = new Line();
        line2.setBounds(0, 220, 305, 2);
        this.add(line2);

        Semaphore semaphore = new Semaphore(2);
        List<Racer> racerList = Arrays.asList(new Racer(semaphore, 102), new Racer(semaphore, 100),
                new Racer(semaphore, 100), new Racer(semaphore, 100));

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
