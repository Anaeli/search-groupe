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
 * Search is of model the files based over the attributes
 * @version  1.0
 * @author Luis Cachi
 */

public class FileSearch extends Asset {    String extension;

    /**
     * Constructor of File
     * File is going to be created with values retrieved from found folders
     * @param name of where the object found
     * @param size in bites of the object
     * @param path of where the object found
     * @param owner Owner name
     * @param extension that has the file
     * @param readOnly its the file readonly
     * @param hidden  its the file hidden
     * */
    public FileSearch(String name, int size, String path, String owner, String extension,
                boolean hidden, boolean readOnly) {
        super(name, size, path, owner, hidden, readOnly);
        this.extension = extension;
    }

    /**
     * this method return the Extension what has the file
     * @return extension of the object
     * */
    public String getExtension() {
        return extension;
    }
}
