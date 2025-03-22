package edu.tucn.str.lecture2.ex5fileParsing;

import javax.swing.*;
import java.io.IOException;

/**
 * @author Radu Miron
 * @version 1
 */
public class Win extends JFrame {
//    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public Win() {
        setBounds(100, 100, 400, 400);
        setLayout(null);

        JLabel label = new JLabel("File Name: ");
        label.setBounds(20, 20, 100, 20);

        JTextField tf = new JTextField();
        tf.setBounds(140, 20, 100, 20);

        JTextArea textArea = new JTextArea();

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(20, 60, 360, 300);

        JButton button = new JButton("Parse File");
        button.setBounds(260, 20, 120, 20);
        button.addActionListener(ae -> {
            new Thread(() -> {
                String fileName = tf.getText();
                try {
                    FileUtils.parseFile(tf.getText()).entrySet()
                            .forEach(e -> textArea.append(e.getKey() + ": " + e.getValue() + "\n"));
                } catch (IOException e) {
                    textArea.setText("Error: " + e.getMessage() + "\n");
                }
                textArea.append("Parsed file: " + fileName + " on "
                        + Thread.currentThread().getName() + "\n");
                textArea.append("\n");
            }).start();
//            Runnable runnable = () -> {
//                textArea.append(Thread.currentThread().getName() + "\n");
//                try {
//                    FileUtils.parseFile(tf.getText()).entrySet()
//                            .forEach(e -> textArea.append(e.getKey() + ": " + e.getValue() + "\n"));
//                } catch (IOException e) {
//                    textArea.setText("Error: " + e.getMessage() + "\n");
//                }
//            };
//
//            EXECUTOR_SERVICE.submit(runnable);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(label);
        add(tf);
        add(button);
        add(scroll);

        setVisible(true);
    }
}
