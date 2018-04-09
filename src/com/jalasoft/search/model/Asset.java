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

    /**
     * constructor of File Search
     * @param name of where the object found
     * @param size in bites of the object
     * @param path of where the object found
     * @param owner Owner name
     * */
    public Asset(String name, int size, String path, String owner){
        this.size = size;
        this.name = name;
        this.owner = owner;
        this.path = path;
    }

    /**
     * this method return the size setup
     * @return size of the object
     * */
    public int getSize() {
        return size;
    }

    /**
     * this method return the name setup
     * @return name of the object
     * */
    public String getName() {
        return name;
    }

    /**
     * this method return the path direction
     * @return path dir
     * */
    public String getPath() {
        return path;
    }

    /**
     * this method returnt the Owner name
     * @return name of the owner
     * */
    public String getOwner() {
        return owner;
    }
}
