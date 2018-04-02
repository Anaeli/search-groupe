package com.jalasoft.search.controller;

import com.jalasoft.search.View.MainWindow;
import com.jalasoft.search.model.Search;

public class Controller {
    private MainWindow searchWindow;
    private Search search;

    public Controller(MainWindow window, Search search){
        this.searchWindow = window;
        this.search = search;
    }

    public void init() {
        searchWindow.displayMainWindow();
        searchWindow.getSearchButton().addActionListener(e -> fillCriteria());
    }

    private void fillCriteria() {
        searchWindow.cleanErrorMessage();
    }
}
