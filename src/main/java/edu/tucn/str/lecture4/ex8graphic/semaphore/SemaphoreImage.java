package edu.tucn.str.lecture4.ex8graphic.semaphore;

import javax.swing.*;
import java.awt.*;

public class SemaphoreImage extends Component {
    @Override
    public void paint(Graphics g) {
        Image image = new ImageIcon("semaphore.jpg").getImage();
        g.drawImage(image,0,0, this);
    }
}
