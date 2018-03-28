/*
 * FileSearch.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.jalasoft.search.model;

/**
 * Search is charged of model the files based over the attributes
 * @version  1.0
 * @author Luis Cachi
 */

public class FileSearch {
    private String path;
    private String name;
    private int size;


    /**
     * constructor of File Search
     * @param path of where the object found
     * @param name what the object has assigned
     * @param size in bites of the objet
     * */
    public FileSearch(String path, String name, int size) {
        this.path = path;
        this.name = name;
        this.size = size;
    }

    /**
     * this method are charged return the Path where the object found
     * @return path into a String
     * */
    public String getPath() {
        return path;
    }

    /**
     * this method are charged return the Name what the object had
     * @return Name into a String
     * */
    public String getName() {
        return name;
    }

}
