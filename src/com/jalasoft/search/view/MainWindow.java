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
    SearchMenu menuPanel;
    SimpleFieldsPanel simpleFieldPanel;
    AdvancedFieldsPanel advancedFieldPanel;
    ResultSearchPanel resultSearchPanel;
    JPanel fieldsPanel;
    HeaderPanel headerPanel;
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
        fieldsPanel = new JPanel(new GridLayout(3,1));
        headerPanel = new HeaderPanel();
        fieldsPanel.add(simpleFieldPanel);
        fieldsPanel.add(advancedFieldPanel);
        fieldsPanel.add(resultSearchPanel);
        this.getContentPane().add(menuPanel, BorderLayout.WEST);
        this.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setVisible(true);
    }

    /**
     * This method returns Filename string of simpleFieldPanel
     * @return string of filenameTextField Component
     * */
    public String getPathText(){
        return simpleFieldPanel.getPathTextField();
    }

    /**
     * This method returns path string of simpleFieldPanel
     * @return string of fileChooser Component
     * */
    public String getFileNameText(){
        return simpleFieldPanel.getFilenameTextField();
    }

    /**
     * This method returns Search Button
     * @return JButton Component
     * */
    public JButton getSearchButton(){
        return resultSearchPanel.getSearchButton();
    }

    public void displayFieldErrorMessage(String errorMessage) {
        headerPanel.setErrorMessage(errorMessage);
    }

    public void cleanErrorMessage() {
        headerPanel.cleanErrorMessage();
    }

    public void addRowResult(Object[] newRow){
        resultSearchPanel.addRowOnTable(newRow);
    }
}