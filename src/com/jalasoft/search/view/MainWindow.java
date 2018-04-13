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
    private HeaderPanel headerPanel;
    private BodyPanel bodyPanel;
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
        headerPanel = new HeaderPanel();
        bodyPanel = new BodyPanel();

        this.getContentPane().add(menuPanel, BorderLayout.WEST);
        this.getContentPane().add(bodyPanel, BorderLayout.CENTER);
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 900);
        this.setVisible(true);

        menuPanel.getSimpleButton().addActionListener(e -> bodyPanel.getSimpleFieldPanel().setVisible(false));
        menuPanel.getAdvancedButton().addActionListener(e -> bodyPanel.getAdvancedFieldPanel().setVisible(true));
    }

    /**
     * This method returns path string of simpleFieldPanel
     * @return string of fileChooser Component
     * */
    public String getPathText(){
        return bodyPanel.getSimpleFieldPanel().getPathTextField();
    }

    /**
     * * This method returns Filename string of simpleFieldPanel
     * @return string of filenameTextField Component
     * */
    public String getFileNameText(){
        return bodyPanel.getSimpleFieldPanel().getFilenameTextField();
    }

    /**
     * This method returns extension string of advancedFieldPanel
     * @return string of extensionTextField Component
     * */
    public String getExtensionText(){
        return bodyPanel.getAdvancedFieldPanel().getExtensionText();
    }

    /**
     * This method returns flag related to hidden field.
     * @return Boolean hiddenCheckBox Component
     * */
    public int getHiddenFlag(){
        return bodyPanel.getAdvancedFieldPanel().getHiddenFlag();
    }

    /**
     * This method returns flag related to hidden field.
     * @return Boolean hiddenCheckBox Component
     * */
    public int getTypeFlag(){
        return bodyPanel.getAdvancedFieldPanel().getTypeFlag();
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
        bodyPanel.getResultSearchPanel().addRowOnTable(newRow);
    }

    /**
     * This method is to clean all rows of table results
     * */
    public void cleanTable(){
        bodyPanel.getResultSearchPanel().cleanTable();
    }
}