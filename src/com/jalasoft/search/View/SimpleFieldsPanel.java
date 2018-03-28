/*
 * Search .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.View;
import javax.swing.*;
import java.awt.*;

/**
 *
 This class implements the GUI for simple search panel.
 using components from swing library
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class SimpleFieldsPanel extends JPanel{
    // Labels
    private JLabel filenameLabel;

    // Text Fields
    private JTextField filenameTextField;

    // Path Field
    private JFileChooser fileChooser;

    // Panels
    private JPanel[][] panelTable;

    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public SimpleFieldsPanel(){
        int row = 1;
        int column = 2;
        this.setLayout(new GridLayout(row, column));
        this.setBorder(BorderFactory.createTitledBorder("Simple Search"));
        filenameLabel = new JLabel("File Name");
        filenameTextField = new JTextField(20);
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        addPanelToGrid(row, column);
        panelTable[0][0].setLayout(new FlowLayout());
        panelTable[0][0].add(filenameLabel);
        panelTable[0][0].add(filenameTextField);
        panelTable[0][1].add(fileChooser);
    }

    /**
     * This method is to add Panels into grid layout according to row and columns
     * @param row quantity of rows to add panels to grid layout
     * @param column quantity of columns to add panels to grid layout
     * */
    private void addPanelToGrid(int row, int column) {
        panelTable = new JPanel[row][column];
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < column; n++) {
                panelTable[m][n] = new JPanel(new GridLayout(1, 1));
                this.add(panelTable[m][n]);
            }
        }
    }

    /**
     * This method returns Filename string of filenameTextField Component
     * @return string of filenameTextField Component
     * */
    public String getFilenameTextField() {
        return filenameTextField.getText();
    }

    /**
     * This method returns path string of fileChooser Component
     * @return string of fileChooser Component
     * */
    public String getPathTextField() {
        return fileChooser.getCurrentDirectory().toString();
    }
}
