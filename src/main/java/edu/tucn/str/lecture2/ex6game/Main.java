package edu.tucn.str.lecture2.ex6game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    private static final int NUM_OF_ENEMIES = 4;

    public static void main(String[] args) throws IOException {
        List<Enemy> enemies = new ArrayList<>();
        MainCharacter character = new MainCharacter();

        for (int i = 0; i < NUM_OF_ENEMIES; i++) {
            Enemy enemy = new Enemy();
            enemies.add(enemy);
            new Engine(enemy).start();
        }

        new Win(enemies, character);
    }
}
