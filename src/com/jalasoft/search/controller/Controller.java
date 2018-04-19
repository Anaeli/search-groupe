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
    private Boolean advancedFlag;
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
        searchWindow.getSearchButton().addActionListener(e -> fillCriteria());
        searchWindow.getCriteriaSaveButton().addActionListener(e -> saveCriteriaOnDataBase());
    }

    /**
     * Event Method that save criteria on Data Base
     */
    private void saveCriteriaOnDataBase() {

    }

    /**
     * Method to set the Advanced Search boolean flag
     */
    public void setAdvancedSearch(boolean Advanced){
        this.advanced = advanced;
    }

    /**
     * Method to validate all files before to set the search criteria
     */
    private boolean validateCriteria(){
        boolean isOk = false;
        isOk = validatePath(searchWindow.getPathText());
        isOk = validateFileName(searchWindow.getFileNameText());
        if(advanced != false){
            // call methods to validate Advanced Search
        }
        if ( isOk ){
            setSearchCriteria();
        }else{
            getInstance().getLogger().error("the validation over the input is failed");
        }
        return true;
    }

    /**
     * Method to validate the String name and set criteria into the Hash map
     */
    private boolean validateFileName(String fileNameText) {
        boolean res = false;
        if(validator.isFileNameCorrect(fileNameText)){
            criteriaMap.put("fileName", fileNameText);
            res = true;
        }else{
            searchWindow.displayFieldErrorMessage("Invalid File Name");
            getInstance().getLogger().error("path no valid to set");;
        }
        return res;
    }

    /**
     * Method to validate the path and set criteria into the Hash map
     */
    private boolean validatePath(String pathText) {
        boolean res = false;
        if(validator.isPathDirection(pathText)){
            criteriaMap.put("path", pathText);
            res = true;
        }else{
            searchWindow.displayFieldErrorMessage("invalid Path");
            getInstance().getLogger().error("path no valid to set");
        }
        return res;
    }


    /// this method will be replaced by setSearchCriteria
    /**
     * Method that set criteria to search files or folders
     */
    private void fillCriteria() {
        searchWindow.cleanTable();
        searchWindow.cleanErrorMessage();
        SearchCriteria criteria = new SearchCriteria();
        String filename = searchWindow.getFileNameText();
        String path = searchWindow.getPathText();
        criteria.setFileName(filename);
        criteria.setPath(path);
        criteria.setExtension(searchWindow.getExtensionText());
        criteria.setOwner(searchWindow.getOwnerText());
        criteria.setHidden(searchWindow.getHiddenFlag());
        criteria.setType(searchWindow.getTypeFlag());
        criteria.setReadOnly(searchWindow.getReadOnlyIndex());
        criteria.setCreatedDateFrom(searchWindow.getFromCreatedDate());
        criteria.setCreatedDateTo(searchWindow.getToCreatedDate());
        criteria.setModifiedDateFrom(searchWindow.getFromModifiedDate());
        criteria.setModifiedDateTo(searchWindow.getToModifiedDate());
        criteria.setAccessedDateFrom(searchWindow.getFromAccessedDate());
        criteria.setAccessedDateTo(searchWindow.getToAccessedDate());
        if (!searchWindow.getFromSize().isEmpty()&&!searchWindow.getToSize().isEmpty()){
            int unit_size = searchWindow.getSizeIndex();
            int from_size = helper.convertStringtoInt(searchWindow.getFromSize());
            int to_size = helper.convertStringtoInt(searchWindow.getToSize());
            int min_size = helper.convertToBytes(from_size, unit_size);
            int max_size = helper.convertToBytes(to_size, unit_size);
            criteria.setSizeMax(max_size);
            criteria.setSizeMax(min_size);
        }
        search.setSearchCriteria(criteria);
        if ( filename.isEmpty() && !path.isEmpty()) {
            search();
        }else if (validator.isFileCorrect(filename)){
           search();
        } else {
            searchWindow.displayFieldErrorMessage("File Name Invalid!!");
        }
        if (path.isEmpty()){
           searchWindow.displayFieldErrorMessage("Path required field!!");
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

    /**
     * Method that set criteria in Search Criteria
     */
    private void setSearchCriteria() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setPath((String) criteriaMap.get("path"));
        criteria.setPath((String) criteriaMap.get("fileName"));
        if(advanced != false){
            // set values for Advanced Search into Search Criteria
        }
    }
}
