package com.jalasoft.search.view;

import javax.swing.JPanel;
import java.awt.FlowLayout;

public class BasePanel extends JPanel{
    /**
     * This method is to add Panels into grid layout according to row and columns
     * @param row quantity of rows to add panels to grid layout
     * @param column quantity of columns to add panels to grid layout
     * */
    protected JPanel[][] addPanelToGrid(int row, int column) {
        JPanel panelTable[][] = new JPanel[row][column];
        for (int m = 0; m < row; m++) {
            for (int n = 0; n < column; n++) {
                panelTable[m][n] = new JPanel(new FlowLayout());
                this.add(panelTable[m][n]);
            }
        }
        return panelTable;
    }
}
