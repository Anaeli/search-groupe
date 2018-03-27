/*
 * Validator .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.controller;

import org.apache.log4j.*;

public class SearchCriteria {
    private  Logger log =  Logger.getLogger(getClass());

    private String fileName;
    private String path;

    public SearchCriteria(String fileName, String path){
        PropertyConfigurator.configure("log4j.properties");
        this.fileName = fileName;
        this.path = path;
    }

    /**
     * Method to return the file name
     * @return file name
     */
    public String getFileName() {
        log.info(fileName);
        return fileName;
    }

    /**
     * Method to return the path
     * @return path
     */
    public String getPath() {
        log.info(path);
        return path;
    }

    /**
     * Method to set the file name
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Method to set the path
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }
}
