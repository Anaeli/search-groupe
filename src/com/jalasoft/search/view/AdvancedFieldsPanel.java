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
    private JTextField extensionTextField;
    private JCheckBox hiddenCheckBox;
    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public AdvancedFieldsPanel(){
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createTitledBorder("Advanced Search"));
        extensionLabel = new JLabel("Ext");
        hiddenLabel = new JLabel("Hidden");
        extensionTextField = new JTextField(10);
        hiddenCheckBox = new JCheckBox();
        this.add(extensionLabel);
        this.add(extensionTextField);
        this.add(hiddenLabel);
        this.add(hiddenCheckBox);

    }

    /**
     * This method returns extension string
     * @return string of extensionTextField Component
     * */
    public String getExtensionText() {
        return extensionTextField.getText();
    }

    /**
     * This method returns extension string
     * @return Boolean of hidden TextField Component
     * */
    public Boolean getHiddenFlag() {
        return hiddenCheckBox.isSelected();
    }

}
