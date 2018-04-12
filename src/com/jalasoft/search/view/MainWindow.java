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
 This class implements the GUI for Search Menu Panel.
 using components from swing library, it contains a JFrame and add to it, more Custom Panels for this application
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class MainWindow extends JFrame {
    private SearchMenu menuPanel;
    private SimpleFieldsPanel simpleFieldPanel;
    private AdvancedFieldsPanel advancedFieldPanel;
    private ResultSearchPanel resultSearchPanel;
    private JPanel fieldsPanel;
    private JPanel mainFieldsPanel;
    private HeaderPanel headerPanel;
    /**
     * Constructor initializes the name of JFrame
     * */
    public MainWindow() {
        super("Search App - Group E");
    }

    /**
     * This method is to add to main window all specific Custom JPanels for the Search App
     * */
    public void displayMainWindow() {
        this.getContentPane().setLayout(new BorderLayout());
        menuPanel = new SearchMenu();
        simpleFieldPanel = new SimpleFieldsPanel();
        advancedFieldPanel = new AdvancedFieldsPanel();
        resultSearchPanel = new ResultSearchPanel();
        mainFieldsPanel = new JPanel();
        mainFieldsPanel.setLayout(new BoxLayout(mainFieldsPanel, BoxLayout.Y_AXIS));
        mainFieldsPanel.setPreferredSize(new Dimension(1000,900));

        headerPanel = new HeaderPanel();
        fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(1,2));
        fieldsPanel.setPreferredSize(new Dimension(1000, 200));
        fieldsPanel.add(simpleFieldPanel);
        fieldsPanel.add(advancedFieldPanel);

        mainFieldsPanel.add(fieldsPanel);
        mainFieldsPanel.add(resultSearchPanel);

        this.getContentPane().add(menuPanel, BorderLayout.WEST);
        this.getContentPane().add(mainFieldsPanel, BorderLayout.CENTER);
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
        this.setVisible(true);

        menuPanel.getSimpleButton().addActionListener(e -> advancedFieldPanel.setVisible(false));
        menuPanel.getAdvancedButton().addActionListener(e -> advancedFieldPanel.setVisible(true));
    }

    /**
     * This method returns path string of simpleFieldPanel
     * @return string of fileChooser Component
     * */
    public String getPathText(){
        return simpleFieldPanel.getPathTextField();
    }

    /**
     * * This method returns Filename string of simpleFieldPanel
     * @return string of filenameTextField Component
     * */
    public String getFileNameText(){
        return simpleFieldPanel.getFilenameTextField();
    }

    /**
     * This method returns extension string of advancedFieldPanel
     * @return string of extensionTextField Component
     * */
    public String getExtensionText(){
        return advancedFieldPanel.getExtensionText();
    }

    /**
     * This method returns flag related to hidden field.
     * @return Boolean hiddenCheckBox Component
     * */
    public Boolean getHiddenFlag(){
        return advancedFieldPanel.getHiddenFlag();
    }

    /**
     * This method returns Search Button
     * @return JButton Component
     * */
    public JButton getSearchButton(){
        return menuPanel.getSearchButton();
    }

    /**
     * This method is to display an error message on Main Window of fields validations
     * */
    public void displayFieldErrorMessage(String errorMessage) {
        headerPanel.setErrorMessage(errorMessage);
    }

    /**
     * This method is to clean error message field
     * */
    public void cleanErrorMessage() {
        headerPanel.cleanErrorMessage();
    }

    /**
     * This method is to set rows on result table
     * */
    public void addRowResult(Object[] newRow){
        resultSearchPanel.addRowOnTable(newRow);
    }

    /**
     * This method is to clean all rows of table results
     * */
    public void cleanTable(){
        resultSearchPanel.cleanTable();
    }
}