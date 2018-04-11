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
import com.sun.org.apache.xpath.internal.operations.Bool;

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
public class AdvancedFieldsPanel extends JPanel {
    private JLabel extensionLabel;
    private JLabel hiddenLabel;
    private JLabel typeLabel;

    private JTextField extensionTextField;
    private JCheckBox hiddenCheckBox;
    private JComboBox typeComboBox;
    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public AdvancedFieldsPanel(){
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
        hiddenLabel = new JLabel("Hidden");
        typeLabel = new JLabel("Type");
        extensionTextField = new JTextField(10);
        extensionTextField.setMaximumSize(extensionTextField.getPreferredSize());
        hiddenCheckBox = new JCheckBox();
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
        hiddenCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * This method set pathTextField Component with path selected on FileChooser
     * */
    private void addComponentsToPanel(){
        this.add(extensionLabel);
        this.add(extensionTextField);
        this.add(hiddenLabel);
        this.add(hiddenCheckBox);
        this.add(typeLabel);
        this.add(typeComboBox);
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
    public Boolean getHiddenFlag() {
        return hiddenCheckBox.isSelected();
    }

}
