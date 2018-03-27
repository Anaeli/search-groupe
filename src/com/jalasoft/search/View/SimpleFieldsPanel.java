package com.jalasoft.search.View;

import javax.swing.*;
import java.awt.*;

public class SimpleFieldsPanel extends JPanel{
    // Labels
    private JLabel filenameLabel;
    private JLabel pathLabel;

    // Text Fields
    private JTextField filenameTextField;
    private JTextField pathTextField;


    private JPanel[][] panelTable;


    public SimpleFieldsPanel(){
        this.setLayout(new GridLayout(10,5));
        this.setBackground(Color.orange);
        this.setBorder(BorderFactory.createTitledBorder("Simple Search"));
        filenameLabel = new JLabel("File Name");
        pathLabel = new JLabel("Path");
        filenameTextField = new JTextField();
        pathTextField = new JTextField();
        addPanelToGrid();
        panelTable[3][1].add(filenameLabel);
        panelTable[3][2].add(filenameTextField);
        panelTable[5][1].add(pathLabel);
        panelTable[5][2].add(pathTextField);
    }

    private void addPanelToGrid() {
        int i = 10;
        int j = 5;
        panelTable = new JPanel[i][j];
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelTable[m][n] = new JPanel(new GridLayout(1, 1));
                this.add(panelTable[m][n]);
            }
        }
    }

    public String getFilenameTextField() {
        return filenameTextField.getText();
    }

    public String getPathTextField() {
        return pathTextField.getText();
    }
}
