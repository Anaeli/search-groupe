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
package com.jalasoft.search.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 This class implements the GUI for advanced search panel.
 using components from swing library
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class AdvancedFieldsPanel extends BasePanel {
    // Labels
    private JLabel extensionLabel;
    private JLabel ownerLabel;
    private JLabel hiddenLabel;
    private JLabel typeLabel;

    private JTextField extensionTextField;
    private JTextField ownerTextField;
    private JComboBox hiddenComboBox;
    private JComboBox typeComboBox;

    // Panels
    private JPanel formPanels[][];
    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public AdvancedFieldsPanel(){
        this.setPreferredSize(new Dimension(500,100));
        this.setLayout(new GridLayout(5,1));
        this.setBorder(BorderFactory.createTitledBorder("Advanced Search"));
        this.setVisible(false);
        initFieldComponents();
        centerAllFields();
        addComponentsToPanel();
    }

    /**
     * This method is to initialize all components for this panel
     * */
    private void initFieldComponents() {
        extensionLabel = new JLabel("Ext");
        ownerLabel = new JLabel("Owner");
        hiddenLabel = new JLabel("Hidden");
        typeLabel = new JLabel("Type");
        extensionTextField = new JTextField(10);
        extensionTextField.setMaximumSize(extensionTextField.getPreferredSize());
        ownerTextField = new JTextField(10);
        ownerTextField .setMaximumSize(extensionTextField.getPreferredSize());
        hiddenComboBox = new JComboBox();
        hiddenComboBox.addItem("Hidden/No Hidden");
        hiddenComboBox.addItem("Hidden");
        hiddenComboBox.addItem("No Hidden");
        typeComboBox = new JComboBox();
        typeComboBox.setMaximumSize(new Dimension(180, typeComboBox.getPreferredSize().height));
        typeComboBox.addItem("File/Folder");
        typeComboBox.addItem("File");
        typeComboBox.addItem("Folder");
    }

    /**
     * This method is to align to center all components
     * */
    private void centerAllFields(){
        extensionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        extensionTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        hiddenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        hiddenComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * This method is to add all components to JPanel
     * */
    private void addComponentsToPanel(){
        formPanels = addPanelToGrid(5, 1);
        formPanels[0][0].add(extensionLabel);
        formPanels[0][0].add(extensionTextField);
        formPanels[0][0].add(ownerLabel);
        formPanels[0][0].add(ownerTextField);
        formPanels[0][0].add(hiddenLabel);
        formPanels[0][0].add(hiddenComboBox);
        formPanels[0][0].add(typeLabel);
        formPanels[0][0].add(typeComboBox);
    }

    /**
     * This method returns extension string
     * @return string of extensionTextField Component
     * */
    public String getExtensionText() {
        return extensionTextField.getText();
    }

    /**
     * This method returns hidden flag it can be true or false
     * @return Boolean of hidden TextField Component
     * */
    public int getHiddenFlag() {
        return hiddenComboBox.getSelectedIndex();
    }

    /**
     * This method returns hidden flag it can be true or false
     * @return Boolean of hidden TextField Component
     * */
    public int getTypeFlag() {
        return typeComboBox.getSelectedIndex();
    }

    /**
     * This method returns owner name
     * @return String owner name
     *
     */
    public String getOwnerText() {
        return ownerTextField.getText();
    }

}
