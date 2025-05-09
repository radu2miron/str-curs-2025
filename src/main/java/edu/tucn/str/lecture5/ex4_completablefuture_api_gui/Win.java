package edu.tucn.str.lecture5.ex4_completablefuture_api_gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Win extends JFrame {
    public Win() {
        super("Current Temperatures");
        this.setSize(500, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // columns and data
        String[] columns = {"City", "Temperature", "Unit"};
        Object[][] data = {};

        // create a table model
        DefaultTableModel model = new DefaultTableModel(data, columns);

        // create JTable with the model
        JTable table = new JTable(model);

        // create a JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 480, 200);

        // create JButton to refresh data
        JButton refreshButton = new JButton("Refresh data");
        refreshButton.setBounds(10, 230, 480, 20);
        refreshButton.addActionListener(e -> refreshData(model));

        this.add(scrollPane);
        this.add(refreshButton);
        this.setVisible(true);
    }

    private void refreshData(DefaultTableModel model) {
        // clear the existing rows
        model.setRowCount(0);

        // get temperatures
        List<TemperatureResult> temperatures = WeatherApiUtils.getTemperatures();
        temperatures.forEach(tr -> model.addRow(new Object[]{
                tr.city().getDisplayName(),
                tr.temperature(),
                tr.unit()}));
        model.fireTableDataChanged();
    }
}
