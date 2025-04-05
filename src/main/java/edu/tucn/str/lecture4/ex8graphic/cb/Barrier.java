package edu.tucn.str.lecture4.ex8graphic.cb;

import javax.swing.*;
import java.awt.*;

public class Barrier extends Component {
    @Override
    public void paint(Graphics g) {
        Image image = new ImageIcon("barrier.jpg").getImage();
        g.drawImage(image,0,0, this);
    }
}
