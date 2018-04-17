/*
 * Main.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search;

import com.jalasoft.search.view.MainWindow;
import com.jalasoft.search.controller.Controller;
import com.jalasoft.search.model.Search;

/*
 * Class to start interaction with search application
 * @version  1.0
 */
public class main {
    public static void main(String[] args) {
        MainWindow searchWindow = new MainWindow();
        Search search = new Search();
        Controller c = new Controller(searchWindow, search);
        c.init();
    }
}
