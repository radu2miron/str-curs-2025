package edu.tucn.str.lecture4.ex8graphic.lock;

import javax.swing.*;
import java.awt.*;

public class LockImage extends Component {
    @Override
    public void paint(Graphics g) {
        Image image = new ImageIcon("lock.jpg").getImage();
        g.drawImage(image,0,0, this);
    }
}
