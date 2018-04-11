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

import com.jalasoft.search.common.Validator;
import com.jalasoft.search.view.MainWindow;
import com.jalasoft.search.model.FileSearch;
import com.jalasoft.search.model.Search;

/*
 * Class to manage integration among view, controller and model
 * @version  1.0
 * @author Eliana Navia
 */
public class Controller {
    private MainWindow searchWindow;
    private Search search;
    private Validator validator;

    /**
     * Constructor method
     * @param window View instance
     * @param search, instance used to search
     */
    public Controller(MainWindow window, Search search){
        this.searchWindow = window;
        this.search = search;
        validator = new Validator();
    }

    /**
     * Method that initialize search process
     */
    public void init() {
        searchWindow.displayMainWindow();
        searchWindow.getSearchButton().addActionListener(e -> fillCriteria());
    }

    /**
     * Method that set criteria to search files or folders
     */
    private void fillCriteria() {
        searchWindow.cleanErrorMessage();
        SearchCriteria criteria = new SearchCriteria();
        String filename = searchWindow.getFileNameText();
        if (validator.isFileNameCorrect(filename)){
            criteria.setFileName(filename);
        } else{
            searchWindow.displayFieldErrorMessage("File Name Invalid");
        }
        criteria.setPath(searchWindow.getPathText());
//        criteria.setExtension();
//        criteria.setHidden();
        search.setSearchCriteria(criteria);
        int counter = 1;
        for (FileSearch file : search.getResults()) {
            searchWindow.addRowResult(new Object[]{counter++, file.getName(), file.getPath()});
        }
    }
}
