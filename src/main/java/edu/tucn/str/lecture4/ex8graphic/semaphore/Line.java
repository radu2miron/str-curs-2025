package edu.tucn.str.lecture4.ex8graphic.semaphore;

import java.awt.*;

public class Line extends Component {
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(0,0,300,0);
    }
}
