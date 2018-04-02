package com.jalasoft.search;

import com.jalasoft.search.View.MainWindow;
import com.jalasoft.search.controller.Controller;
import com.jalasoft.search.model.Search;

public class main {
    public static void main(String[] args) {
        MainWindow searchWindow = new MainWindow();
        Search search = new Search();
        Controller c = new Controller(searchWindow, search);
        c.init();
    }

}
