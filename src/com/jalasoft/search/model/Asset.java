package com.jalasoft.search.model;

/**
 *  This class implements the Folder for model different object into a dir.
 *
 * @version  1.0
 * @author Luis Cachi
 */
public class Asset {
    private int size;
    private String name;
    private String path;
    private String owner;

    public Asset(String name, int size, String path, String owner){
        this.size = size;
        this.name = name;
        this.owner = owner;
        this.path = path;
    }

}

