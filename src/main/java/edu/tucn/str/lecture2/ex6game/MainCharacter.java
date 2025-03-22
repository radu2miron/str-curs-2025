package edu.tucn.str.lecture2.ex6game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Radu Miron
 * @version 1
 */
public class MainCharacter extends JComponent {
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0,0,60,20);
    }
}
