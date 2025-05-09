package edu.tucn.str.lecture5.ex3_future_api_gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;

/**
 * @author Radu Miron
 * @version 1
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new Win();
    }
}
