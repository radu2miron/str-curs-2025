package edu.tucn.str.lecture5.ex4_completablefuture_api_gui;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new Win();
    }
}
