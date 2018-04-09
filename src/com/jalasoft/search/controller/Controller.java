package com.jalasoft.search.controller;

import com.jalasoft.search.common.Validator;
import com.jalasoft.search.view.MainWindow;
import com.jalasoft.search.model.FileSearch;
import com.jalasoft.search.model.Search;

public class Controller {
    private MainWindow searchWindow;
    private Search search;
    private Validator validator;

    public Controller(MainWindow window, Search search){
        this.searchWindow = window;
        this.search = search;
        validator = new Validator();
    }

    public void init() {
        searchWindow.displayMainWindow();
        searchWindow.getSearchButton().addActionListener(e -> fillCriteria());
    }

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
        search.SetSearchCritera(criteria);
        int counter = 1;
        for (FileSearch file : search.getResults()) {
            searchWindow.addRowResult(new Object[]{counter++, file.getName(), file.getPath()});
        }
    }
}
