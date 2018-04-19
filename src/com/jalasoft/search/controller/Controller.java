/*
 * Controller.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.controller;

import com.jalasoft.search.common.Helper;
import com.jalasoft.search.common.Validator;
import com.jalasoft.search.model.Asset;
import com.jalasoft.search.view.MainWindow;
import com.jalasoft.search.model.Search;
import com.jalasoft.search.model.QueryManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import static com.jalasoft.search.common.Log.getInstance;

/*
 * Class to manage integration among view, controller and model
 * @version  1.0
 * @author Eliana Navia
 */
public class Controller {
    private MainWindow searchWindow;
    private Search search;
    private Validator validator;
    private Helper helper;
    private boolean advanced;
    private HashMap<String, Object > criteriaMap;

    /**
     * Constructor method to integrate the view, controller and model
     * @param window View instance
     * @param search, instance used to search
     */
    public Controller(MainWindow window, Search search){
        this.searchWindow = window;
        this.search = search;
        validator = new Validator();
        helper = new Helper();
        this.advanced = false;
        this.criteriaMap = new HashMap<>();
    }

    /**
     * Method that initialize search process
     */
    public void init() {
        searchWindow.displayMainWindow();
        searchWindow.getSearchButton().addActionListener(e -> searchBasedOnSearchCriteria());
        searchWindow.getCriteriaSaveButton().addActionListener(e -> saveCriteriaOnDataBase());
    }

    /**
     * Method to validate all files and set search criteria with valid values
     */
    private SearchCriteria validateSearchCriteria(){
        SearchCriteria sCriteria = new SearchCriteria();
        String path = searchWindow.getPathText();
        String fileName = validateTheString(searchWindow.getFileNameText());
        int minSize = getIntValue(searchWindow.getFromSize());
        int maxSize = getIntValue(searchWindow.getToSize());
        Date fCDate = searchWindow.getFromCreatedDate();
        Date tCDate = searchWindow.getToCreatedDate();
        Date fADate = searchWindow.getFromAccessedDate();
        Date tADate = searchWindow.getToAccessedDate();
        Date fMDate = searchWindow.getFromModifiedDate();
        Date tMDate = searchWindow.getToModifiedDate();
        String owner = validateTheString(searchWindow.getOwnerText());
        String extension = validateTheString(searchWindow.getExtensionText());

        if(validatePath(path)){
            sCriteria.setPath(path);
        }
        if(fileName != null){
            sCriteria.setFileName(fileName);
        }
        if (validateSizeGraterThan(minSize, maxSize)){
            sCriteria.setSizeMin(minSize);
            sCriteria.setSizeMax(maxSize);
        }

        if(advanced){
            if (owner != null)
                sCriteria.setOwner(owner);
            if (extension != null)
                sCriteria.setExtension(extension);
            if (validateDateGraterThan(fCDate, tCDate)){
                sCriteria.setCreatedDateFrom(fCDate);
                sCriteria.setCreatedDateTo(tCDate);
            }
            if (validateDateGraterThan(fADate, tADate)){
                sCriteria.setAccessedDateFrom(fADate);
                sCriteria.setAccessedDateTo(tADate);
            }
            if (validateDateGraterThan(fMDate, tMDate)){
                sCriteria.setModifiedDateFrom(fMDate);
                sCriteria.setModifiedDateTo(tMDate);
            }
            sCriteria.setType(searchWindow.getTypeFlag());
            sCriteria.setHidden(searchWindow.getTypeFlag());
            sCriteria.setReadOnly(searchWindow.getReadOnlyIndex());

        }
        return sCriteria;
    }

    /**
     * Method to validate the Size grater than
     * @param min, max: the min should be less than maz
     * @return true if meet the criteria
     */
    private boolean validateSizeGraterThan(int min, int max) {
        if(validator.minInLessThanMax(min, max)){
            return true;
        }else{
            searchWindow.displayFieldErrorMessage("The size values are not Setup correctly");
            getInstance().getLogger().error("The size values are not Setup correctly the Max should be grater than Min");
        }
        return false;
    }

    /**
     * Method to validate a Date is greater than other
     * @param from, to: the from should be less than to date
     * @return true if meet the criteria
     */
    private boolean validateDateGraterThan(Date from, Date to) {
        boolean res = false;
        if(from != null && to != null){
            if(validator.isValidDate(from) && validator.isValidDate(to)){
                res = validator.dateFromIsLessThanTo(from, to);
                if (res == false){
                    searchWindow.displayFieldErrorMessage("The Date is not Setup correctly");
                    getInstance().getLogger().error("The Date is not Setup correctly");
                }
            }
        }
        return res;
    }

    /**
     * Method to validate the String input is valid String
     * @param text String to evaluate teh Criteria
     * @return the String if meet the Criteria and null if no meet it
     */
    private String validateTheString(String text) {
        String res = null;
        if(!text.isEmpty()){
            if(validator.isFileNameCorrect(text)){
                res = text;
            }else{
                searchWindow.displayFieldErrorMessage("Invalid Text Field input");
                getInstance().getLogger().error("Some test input are field with no valid value");
            }
        }else{
            res = text;
        }
        return res;
    }

    /**
     * Method to validate is the path is valid
     * @param pathText validate the String path exist
     * @return True if the path exist
     */
    private boolean validatePath(String pathText) {
        boolean res = false;
        if(validator.validPath(pathText)){
            res = true;
        }else{
            searchWindow.displayFieldErrorMessage("invalid Path");
            getInstance().getLogger().error("path no valid to set");
        }
        return res;
    }


    /// this method will be replaced by setSearchCriteria
    /**
     * Event Method that save criteria on Data Base
     */
    private void saveCriteriaOnDataBase() {
        searchWindow.getSearchButton().addActionListener(e -> searchBasedOnSearchCriteria());
    }

    /**
     * Method to set the Advanced Search boolean flag
     */
    public void setAdvancedSearch(boolean Advanced){
        this.advanced = advanced;
    }

    /**
     * Method to validate all files and set search criteria with valid values
     */


    /**
     * Method to transform the String setup into Int also convert it in bites
     * @param intValue String to Transform in Integer
     * @return int value in bites
     */
    private int getIntValue(String intValue) {
        int value = -1;
        if (!intValue.isEmpty()){
            if( validator.isNotEmpty(intValue) ){
                try{
                    int unit_size = searchWindow.getSizeIndex();
                    int num = helper.convertStringToInt(intValue);
                    value = helper.convertToBytes(num, unit_size);
                }catch (Exception e){
                    searchWindow.displayFieldErrorMessage("invalid input is required an integer");
                    getInstance().getLogger().error("The Size is not Setup correctly");
                }
            }else{
                searchWindow.displayFieldErrorMessage("The size is not Setup correctly");
                getInstance().getLogger().error("The Size is not Setup correctly");
            }
        }
        return value;
    }

    /// this method will be replaced by setSearchCriteria
    /**
     * Method that set criteria to search files or folders
     */
    private void searchBasedOnSearchCriteria() {
        searchWindow.cleanTable();
        searchWindow.cleanErrorMessage();
        SearchCriteria criteria = validateSearchCriteria();
        if (!searchWindow.hasError()) {
            search.setSearchCriteria(criteria);
            search();
        }
    }

    /**
     * Method to search a file o folder
     */
    private void search() {
        try {
            int counter = 1;
            for (Asset file : search.getResults()) {
                searchWindow.addRowResult(new Object[]{counter++, file.getName(), file.getPath()});
            }
        }catch (Exception e){searchWindow.displayFieldErrorMessage("No Records Found");}
    }
}
