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
import java.util.Date;

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
        this.setSize(1020, 700);
        this.setResizable(false);
        this.setVisible(true);

        menuPanel.getSimpleButton().addActionListener(e -> bodyPanel.getAdvancedFieldPanel().setVisible(false));
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
     * This method returns owner name
     * @return String owner name
     *
     */
    public String getOwnerText(){
        return bodyPanel.getAdvancedFieldPanel().getOwnerText();
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

    /**
     * This method returns get From Created Date
     * @return Date From Created Date
     *
     */
    public Date getFromCreatedDate() {
        return bodyPanel.getAdvancedFieldPanel().getFromCreatedDate();
    }

    /**
     * This method returns get From Modified Date
     * @return Date From Modified Date
     *
     */
    public Date getFromModifiedDate() {
        return bodyPanel.getAdvancedFieldPanel().getFromModifiedDate();
    }

    /**
     * This method returns get From Accessed Date
     * @return Date From Accessed Date
     *
     */
    public Date getFromAccessedDate() {
        return bodyPanel.getAdvancedFieldPanel().getFromAccessedDate();
    }

    /**
     * This method returns get From Created Date
     * @return Date From Created Date
     *
     */
    public Date getToCreatedDate() {
        return bodyPanel.getAdvancedFieldPanel().getToCreatedDate();
    }

    /**
     * This method returns get From Modified Date
     * @return Date From Modified Date
     *
     */
    public Date getToModifiedDate() {
        return bodyPanel.getAdvancedFieldPanel().getToModifiedDate();
    }

    /**
     * This method returns get From Accessed Date
     * @return Date From Accessed Date
     *
     */
    public Date getToAccessedDate() {
        return bodyPanel.getAdvancedFieldPanel().getToAccessedDate();
    }

    /**
     * This method returns Read Only value, it can be both = 0, read only = 1 and no read only = 2
     * @return int of Read Only TextField Component
     * */
    public int getReadOnlyIndex() {
        return bodyPanel.getAdvancedFieldPanel().getReadOnlyIndex();
    }

    /**
     * This method returns size value, it can be KB = 0, MB = 1 and GB = 2
     * @return int of size Combo box component
     * */
    public int getSizeIndex() {
        return bodyPanel.getAdvancedFieldPanel().getSizeIndex();
    }

    /**
     * This method returns From Size
     * @return String owner name
     *
     */
    public String getFromSize() {
        return bodyPanel.getAdvancedFieldPanel().getFromSize();
    }

    /**
     * This method returns To Size
     * @return String owner name
     *
     */
    public String getToSize() {
        return bodyPanel.getAdvancedFieldPanel().getToSize();
    }

    /**
     * This method returns Save Criteria Button to implement its event on Controller
     * @return JButton criteria Save Button
     *
     */
    public JButton getCriteriaSaveButton() {
        return bodyPanel.getCriteriaPanel().getCriteriaSaveButton();
    }
}