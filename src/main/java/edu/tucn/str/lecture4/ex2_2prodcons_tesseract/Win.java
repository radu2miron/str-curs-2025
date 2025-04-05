package edu.tucn.str.lecture4.ex2_2prodcons_tesseract;

import javax.swing.*;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Radu Miron
 * @version 1
 */
public class Win extends JFrame {
    private ArrayBlockingQueue<File> queue;
    private JTextArea logArea;

    Win(ArrayBlockingQueue<File> queue) {
        this.queue = queue;
        setTitle("Text Extractor");
        setBounds(800, 300, 380, 460);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField filePathInput = new JTextField();
        filePathInput.setBounds(200, 20, 160, 20);
        filePathInput.setEnabled(false);

        JButton selButton = new JButton("Select File");
        selButton.setBounds(20, 20, 160, 20);

        selButton.addActionListener(e -> { // 'Select File click handler'
            JFileChooser fileChooser = new JFileChooser("lecture4"); // open file chooser in 'testfiles' dir
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // enables file choosing only
            int r = fileChooser.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                filePathInput.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });

        JButton processButton = new JButton("Process Files");
        processButton.setBounds(20, 60, 340, 20);

        logArea = new JTextArea();
        JScrollPane scrollableResults = new JScrollPane(logArea);
        scrollableResults.setBounds(20, 100, 340, 300);

        processButton.addActionListener(ae -> { // 'Process Files' click handler
            new ProducerThread(queue, new File(filePathInput.getText()), logArea).start();
        });

        add(filePathInput);
        add(processButton);
        add(scrollableResults);
        add(selButton);

        setVisible(true);
    }

    public JTextArea getLogArea() {
        return logArea;
    }
}
