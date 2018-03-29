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
package com.jalasoft.search.View;
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
        fieldsPanel.add(simpleFieldPanel);
        fieldsPanel.add(advancedFieldPanel);
        fieldsPanel.add(resultSearchPanel);
        this.getContentPane().add(menuPanel, BorderLayout.WEST);
        this.getContentPane().add(fieldsPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow window = new MainWindow();
        window.displayMainWindow();
    }

    /**
     * This method returns Filename string of simpleFieldPanel
     * @return string of filenameTextField Component
     * */
    public String getPathText(){
        return simpleFieldPanel.getFilenameTextField();
    }

    /**
     * This method returns path string of simpleFieldPanel
     * @return string of fileChooser Component
     * */
    public String getFileNameText(){
        return simpleFieldPanel.getPathTextField();
    }
}