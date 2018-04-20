/*
 * Criteria .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 *
 This class implements the GUI for Criteria panel.
 using components from swing library
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class CriteriaPanel extends JPanel {
    private JPanel tablePanel;
    private JPanel saveCriteriaFormPanel;
    private JLabel criteriaSaveLabel;
    private JTextField criteriaSaveTextField;
    private JButton criteriaSaveButton;

    private JTable criteriaTable;
    private DefaultTableModel defaultTableModel;
    //headers for the table
    private String[] headerTable = new String[] { "ID", "Criteria Name" };

    /**
     * Constructor initializes init method
     * */
    public CriteriaPanel(){
        init();
    }

    /**
     * This initializes this Panel as BoxLayout also add components to this JPanel
     * */
    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Criteria Table"));
        this.setPreferredSize(new Dimension(1000, 200));

        tablePanel = new JPanel(new GridLayout(1,1));
        tablePanel.setPreferredSize(new Dimension(700,200));

        defaultTableModel = new DefaultTableModel(new Object[][] { }, headerTable);
        criteriaTable = new JTable(defaultTableModel);
        tablePanel.add(new JScrollPane(criteriaTable));

        saveCriteriaFormPanel = new JPanel(new GridLayout(3,1));
        saveCriteriaFormPanel.setLayout(new BoxLayout(saveCriteriaFormPanel, BoxLayout.Y_AXIS));
        saveCriteriaFormPanel.setPreferredSize(new Dimension(300,200));
        this.add(tablePanel);
        this.add(saveCriteriaFormPanel);
        criteriaSaveLabel = new JLabel("Criteria Name");
        criteriaSaveLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        criteriaSaveTextField = new JTextField(15);
        criteriaSaveTextField.setMaximumSize(criteriaSaveTextField.getPreferredSize());
        criteriaSaveTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        criteriaSaveButton = new JButton("Save");
        criteriaSaveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveCriteriaFormPanel.add(criteriaSaveLabel);
        saveCriteriaFormPanel.add(criteriaSaveTextField);
        saveCriteriaFormPanel.add(criteriaSaveButton);
    }

    /**
     * This method is to add rows on result table about search results
     * */
    public void addRowOnTable(Object[] newRow){
        defaultTableModel.addRow(newRow);
    }

    /**
     * This method returns JButton to save a criteria
     * */
    public JButton getCriteriaSaveButton(){
        return criteriaSaveButton;
    }

    /**
     * This method returns JTable of criteria
     * */
    public JTable getCriteriaTable(){
        return criteriaTable;
    }

    /**
     * This method returns Default table model of JTable of criteria
     * */
    public DefaultTableModel getCriteriaDefaultModel(){
        return defaultTableModel;
    }

    /**
     * This method returns Criteria text field string
     * */
    public String getCriteriaName(){
        return criteriaSaveTextField.getText();
    }
}
