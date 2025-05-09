package edu.tucn.str.lecture5.ex3_future_api_gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author Radu Miron
 * @version 1
 */
public class Win extends JFrame {
    public Win() {
        super("Crypto Market Prices");
        this.setSize(700, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // columns and data
        String[] columns = {"Rank", "Name", "Price (USD)", "MarketCap (USD)"};
        Object[][] data = {
                {"1", "Bitcoin", 0.00, 0.00}
        };

        // create a table model
        DefaultTableModel model = new DefaultTableModel(data, columns);

        // create JTable with the model
        JTable table = new JTable(model);

        // create a JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 680, 200);

        // create JButton to refresh data
        JButton refreshButton = new JButton("Refresh data");
        refreshButton.setBounds(10, 230, 680, 20);
        refreshButton.addActionListener(e -> refreshData(model));

        // create disclaimer label
        JLabel disclaimerLabel = new JLabel("<html>" +
                "You should be prepared to lose all the money you invest in cryptoassets.<BR>" +
                "The cryptoasset market is largely unregulated.<BR>" +
                "There is a risk of losing money or any cryptoassets you purchase due to risks such as:<BR>" +
                "cyber-attacks, financial crime and firm failure.</html>"
        );
        disclaimerLabel.setBounds(10, 270, 680, 100);
        disclaimerLabel.setForeground(Color.RED);

        this.add(scrollPane);
        this.add(refreshButton);
        this.add(disclaimerLabel);
        this.setVisible(true);
    }

    private void refreshData(DefaultTableModel model) {
        // clear the existing rows
        model.setRowCount(0);

        // get coins' data
        List<CoinModel> coins = CoinsApiUtils.getCoins();
        coins.forEach(c -> model.addRow(new Object[]{
                c.data().rank(),
                c.data().name(),
                trim(c.data().priceUsd()),
                trim(c.data().marketCapUsd())}));
        model.fireTableDataChanged();
    }

    private String trim(String val) {
        int pIndex = val.indexOf(".");
        return val.substring(0, pIndex + 5);
    }
}
