package edu.tucn.str.lecture2.ex6game;

import java.util.Random;

/**
 * @author Radu Miron
 * @version 1
 */
public class Engine extends Thread {
    private static final int MAX_SPEED = 10;

    int speed = new Random().nextInt(MAX_SPEED);
    private Enemy enemy;

    public Engine(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void run() {
        while (this.enemy.getY() < 720) {
            this.enemy.setLocation(this.enemy.getX(), this.enemy.getY() + 2 + speed);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
