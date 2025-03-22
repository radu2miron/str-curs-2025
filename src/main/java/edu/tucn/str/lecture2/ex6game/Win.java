package edu.tucn.str.lecture2.ex6game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Win extends JFrame implements KeyListener {
    private static final int SIZE = 700;
    private List<Enemy> enemies;
    private MainCharacter character;

    public Win(List<Enemy> enemies, MainCharacter character) {
        this.enemies = enemies;
        this.character = character;
        init();
    }

    public void init() {
        this.setBounds(100, 100, SIZE, SIZE);
        this.setLayout(null);
        this.setResizable(false);
        int dist = Math.round(SIZE / (enemies.size() + 1));

        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            int x = dist * (i + 1);
            enemy.setBounds(x, 20, 20, 20);
            this.add(enemy);
        }

        character.setBounds(320, 640, 60, 20);
        this.add(character);

        this.addKeyListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        String letter = keyEvent.getKeyChar() + "";

        if (letter.equalsIgnoreCase("a")) {
            character.setLocation(character.getX() - 5, character.getY());
        } else if (letter.equalsIgnoreCase("d")) {
            character.setLocation(character.getX() + 5, character.getY());
        } else if (letter.equalsIgnoreCase("w")) {
            character.setLocation(character.getX(), character.getY() - 5);
        } else if (letter.equalsIgnoreCase("s")) {
            character.setLocation(character.getX(), character.getY() + 5);
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
