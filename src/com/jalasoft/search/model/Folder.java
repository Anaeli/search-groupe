package com.jalasoft.search.model;

/**
 * This class implements the Folder for model a Folder object.
 * @version  1.0
 * @author Luis Cachi
 */
public class Folder extends Asset{
    int cantOfFiles;
    public Folder(String name, int size, String path, String owner, int cantOfFiles) {
        super(name, size, path, owner);
        this.cantOfFiles = cantOfFiles;
    }
}
