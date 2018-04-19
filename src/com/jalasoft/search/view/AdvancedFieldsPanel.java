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

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

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
    private JLabel fromCreatedLabel;
    private JLabel toCreatedLabel;
    private JLabel fromModifiedLabel;
    private JLabel toModifiedLabel;
    private JLabel fromAccessedLabel;
    private JLabel toAccessedLabel;
    private JLabel fromSizeLabel;
    private JLabel toSizeLabel;

    private JTextField extensionTextField;
    private JTextField ownerTextField;
    private JTextField fromSizeTextField;
    private JTextField toSizeTextField;
    private JComboBox sizeComboBox;
    private JComboBox hiddenComboBox;
    private JComboBox typeComboBox;
    private JComboBox readOnlyComboBox;

    private JXDatePicker fromCreatedDP;
    private JXDatePicker toCreatedDP;
    private JXDatePicker fromModifiedDP;
    private JXDatePicker toModifiedDP;
    private JXDatePicker fromAccessedDP;
    private JXDatePicker toAccessedDP;

    // Panels
    private JPanel formPanels[][];
    private JLabel readOnlyLabel;

    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public AdvancedFieldsPanel(){
        this.setPreferredSize(new Dimension(500,100));
        this.setLayout(new GridLayout(6,1));
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
        readOnlyLabel = new JLabel("Read Only");
        fromSizeLabel = new JLabel("Size From");
        toSizeLabel = new JLabel("To");
        extensionTextField = new JTextField(10);
        extensionTextField.setMaximumSize(extensionTextField.getPreferredSize());
        ownerTextField = new JTextField(10);
        ownerTextField .setMaximumSize(extensionTextField.getPreferredSize());
        fromSizeTextField = new JTextField(10);
        toSizeTextField = new JTextField(10);
        hiddenComboBox = new JComboBox();
        hiddenComboBox.addItem("Hidden/No Hidden");
        hiddenComboBox.addItem("Hidden");
        hiddenComboBox.addItem("No Hidden");
        typeComboBox = new JComboBox();
        typeComboBox.setMaximumSize(new Dimension(180, typeComboBox.getPreferredSize().height));
        typeComboBox.addItem("File/Folder");
        typeComboBox.addItem("File");
        typeComboBox.addItem("Folder");
        readOnlyComboBox = new JComboBox();
        readOnlyComboBox.setMaximumSize(new Dimension(180, typeComboBox.getPreferredSize().height));
        readOnlyComboBox.addItem("Read Only/No Read Only");
        readOnlyComboBox.addItem("Read Only");
        readOnlyComboBox.addItem("No Read Only");
        sizeComboBox = new JComboBox();
        sizeComboBox.setMaximumSize(new Dimension(180, typeComboBox.getPreferredSize().height));
        sizeComboBox.addItem("KB");
        sizeComboBox.addItem("MB");
        sizeComboBox.addItem("GB");
        fromCreatedLabel = new JLabel("Created From");
        toCreatedLabel = new JLabel("To");
        fromModifiedLabel = new JLabel("Modified From");
        toModifiedLabel = new JLabel("To");
        fromAccessedLabel = new JLabel("Accessed From");
        toAccessedLabel = new JLabel("To");
        fromCreatedDP = new JXDatePicker();
        toCreatedDP = new JXDatePicker();
        fromModifiedDP = new JXDatePicker();
        toModifiedDP = new JXDatePicker();
        fromAccessedDP = new JXDatePicker();
        toAccessedDP = new JXDatePicker();
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
        formPanels = addPanelToGrid(6,1);
        formPanels[0][0].add(extensionLabel);
        formPanels[0][0].add(extensionTextField);
        formPanels[0][0].add(ownerLabel);
        formPanels[0][0].add(ownerTextField);
        formPanels[0][0].add(typeLabel);
        formPanels[0][0].add(typeComboBox);
        formPanels[1][0].add(hiddenLabel);
        formPanels[1][0].add(hiddenComboBox);
        formPanels[1][0].add(readOnlyLabel);
        formPanels[1][0].add(readOnlyComboBox);

        //CreatedCalendars
        formPanels[2][0].add(fromCreatedLabel);
        formPanels[2][0].add(fromCreatedDP);
        formPanels[2][0].add(toCreatedLabel);
        formPanels[2][0].add(toCreatedDP);

        //ModifiedCalendars
        formPanels[3][0].add(fromModifiedLabel);
        formPanels[3][0].add(fromModifiedDP);
        formPanels[3][0].add(toModifiedLabel);
        formPanels[3][0].add(toModifiedDP);

        //AccessedCalendars
        formPanels[4][0].add(fromAccessedLabel);
        formPanels[4][0].add(fromAccessedDP);
        formPanels[4][0].add(toAccessedLabel);
        formPanels[4][0].add(toAccessedDP);

        //SizeFields
        formPanels[5][0].add(fromSizeLabel);
        formPanels[5][0].add(fromSizeTextField);
        formPanels[5][0].add(toSizeLabel);
        formPanels[5][0].add(toSizeTextField);
        formPanels[5][0].add(sizeComboBox);
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
     * This method returns Read Only value, it can be both = 0, read only = 1 and no read only = 2
     * @return int of Read Only TextField Component
     * */
    public int getReadOnlyIndex() {
        return readOnlyComboBox.getSelectedIndex();
    }

    /**
     * This method returns size value, it can be KB = 0, MB = 1 and GB = 2
     * @return int of size Combo box component
     * */
    public int getSizeIndex() {
        return sizeComboBox.getSelectedIndex();
    }

    /**
     * This method returns owner name
     * @return String owner name
     *
     */
    public String getOwnerText() {
        return ownerTextField.getText();
    }

    /**
     * This method returns From Size
     * @return String owner name
     *
     */
    public String getFromSize() {
        return fromSizeTextField.getText();
    }

    /**
     * This method returns To Size
     * @return String owner name
     *
     */
    public String getToSize() {
        return toSizeTextField.getText();
    }

    /**
     * This method returns get From Created Date
     * @return Date From Created Date
     *
     */
    public Date getFromCreatedDate() {
        return fromCreatedDP.getDate();
    }

    /**
     * This method returns get From Modified Date
     * @return Date From Modified Date
     *
     */
    public Date getFromModifiedDate() {
        return fromModifiedDP.getDate();
    }

    /**
     * This method returns get From Accessed Date
     * @return Date From Accessed Date
     *
     */
    public Date getFromAccessedDate() {
        return fromAccessedDP.getDate();
    }

    /**
     * This method returns get From Created Date
     * @return Date From Created Date
     *
     */
    public Date getToCreatedDate() {
        return toCreatedDP.getDate();
    }

    /**
     * This method returns get From Modified Date
     * @return Date From Modified Date
     *
     */
    public Date getToModifiedDate() {
        return toModifiedDP.getDate();
    }

    /**
     * This method returns get From Accessed Date
     * @return Date From Accessed Date
     *
     */
    public Date getToAccessedDate() {
        return toAccessedDP.getDate();
    }
}
