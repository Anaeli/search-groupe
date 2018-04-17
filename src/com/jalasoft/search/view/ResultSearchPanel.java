package com.jalasoft.search.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultSearchPanel extends JPanel {
    private JTable resultTable;
    private DefaultTableModel defaultTableModel;

    //headers for the table
    private String[] headerTable = new String[] { "#", "Filename", "Path", "Extension", "Hidden" };

    public ResultSearchPanel(){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder("Results"));
        this.setPreferredSize(new Dimension(1000, 300));
        defaultTableModel = new DefaultTableModel(new Object[][] { }, headerTable);
        resultTable = new JTable(defaultTableModel);
        this.add(new JScrollPane(resultTable), BorderLayout.CENTER);
    }

    /**
     * This method is to add rows on result table about search results
     * */
    public void addRowOnTable(Object[] newRow){
        defaultTableModel.addRow(newRow);
    }

    /**
     * This method is to clean results table
     * */
    public void cleanTable(){
        defaultTableModel.setRowCount(0);
    }
}
