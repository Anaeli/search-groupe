package com.jalasoft.search.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultSearchPanel extends JPanel {
    private JButton searchButton;
    private JTable resultTable;
    private DefaultTableModel defaultTableModel;

    //headers for the table
    private String[] headerTable = new String[] { "#", "Filename", "Path" };

    public ResultSearchPanel(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Results"));
        searchButton = new JButton("Search");
        defaultTableModel = new DefaultTableModel(new Object[][] { }, headerTable);
        resultTable = new JTable(defaultTableModel);
        this.add(new JScrollPane(resultTable), BorderLayout.CENTER);
        this.add(searchButton, BorderLayout.EAST);
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void addRowOnTable(Object[] newRow){
        defaultTableModel.addRow(newRow);
    }
}
