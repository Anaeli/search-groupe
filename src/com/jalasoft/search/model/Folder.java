/*
 * Folder.java
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
 * This class implements the Folder for model a Folder object.
 * @version  1.0
 * @author Luis Cachi
 */
public class Folder extends Asset{
    int cantOfFiles;

    /**
     * Constructor of Folder
     * Folder is going to be created with values retrieved from found folders
     * @param name of where the object found
     * @param size in bites of the object
     * @param path of where the object found
     * @param owner Owner name
     * @param cantOfFiles number of files that has the folder
     * @param readOnly its the file readonly
     * @param hidden  its the file hidden
     * */
    public Folder(String name, int size, String path, String owner, int cantOfFiles,
                  boolean hidden, boolean readOnly) {
        super(name, size, path, owner, hidden, readOnly);
        this.cantOfFiles = cantOfFiles;
    }

    /**
     * this method return the number of files what has the folder
     * @return extension of the object
     * */
    public int getCantOfFiles() {
        return cantOfFiles;
    }
}
