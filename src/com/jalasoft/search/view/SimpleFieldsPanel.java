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
import java.io.File;

/**
 *
 This class implements the GUI for simple search panel.
 using components from swing library
 *
 * @version  1.0
 * @author Rodrigo Saul Cespedes Murillo
 */
public class SimpleFieldsPanel extends JPanel{
    // Labels
    private JLabel filenameLabel;
    private JLabel pathLabel;

    // Text Fields
    private JTextField filenameTextField;
    private JTextField pathTextField;

    // Path Field
    private JFileChooser fileChooser;

    // Button Field
    private JButton fileChooserButton;

    // Panels
    private JPanel fileChooserPanel;

    /**
     * Constructor initializes this Panel as grid layout also add components to this JPanel
     * */
    public SimpleFieldsPanel(){
        this.setPreferredSize(new Dimension(400,100));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Simple Search"));
        filenameLabel = new JLabel("File Name");
        pathLabel = new JLabel("Path");
        filenameTextField = new JTextField(20);
        filenameTextField.setMaximumSize(filenameTextField.getPreferredSize());
        pathTextField = new JTextField(40);
        pathTextField.setMaximumSize(pathTextField.getPreferredSize());
        fileChooserButton = new JButton("Select");
        fileChooser = new JFileChooser();
        fileChooserPanel = new JPanel(null);
        centerAllFields();
        addComponentsToPanel();
        fileChooserButton.addActionListener(e -> selectPath());
    }

    /**
     * This method set pathTextField Component with path selected on FileChooser
     * */
    private void selectPath(){
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if( fileChooser.showOpenDialog(fileChooserPanel) == JFileChooser.APPROVE_OPTION){
            pathTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    /**
     * This method is to align to center all components
     * */
    private void centerAllFields(){
        filenameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        filenameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        pathLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        pathTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        fileChooserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    /**
     * This method is to tadd all components to JPanel
     * */
    private void addComponentsToPanel(){
        this.add(filenameLabel);
        this.add(filenameTextField);
        this.add(pathLabel);
        this.add(pathTextField);
        this.add(fileChooserButton);
    }

    /**
     * This method returns Filename string of filenameTextField Component
     * @return string of filenameTextField Component
     * */
    public String getFilenameTextField() {
        return filenameTextField.getText();
    }

    /**
     * This method returns path string of pathTextField Component
     * @return string of fileChooser Component
     * */
    public String getPathTextField() {
        return pathTextField.getText().toString();
    }
}
