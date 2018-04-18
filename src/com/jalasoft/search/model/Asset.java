package com.jalasoft.search.model;

import java.util.Date;

/**
 *  This class implements the objects for model different object into a dir.
 *
 * @version  1.0
 * @author Luis Cachi
 */
public class Asset {
    private int size;
    private String name;
    private String path;
    private String owner;
    private boolean hidden;
    private boolean readOnly;
    private Date creationDate;
    private Date accessDate;
    private Date modifiedDate;

    /**
     * constructor of Asset
     * @param name of where the object found
     * @param size in bites of the object
     * @param path of where the object found
     * @param owner Owner name
     * @param readOnly its the file readonly
     * @param hidden  its the file hidden
     * */
    public Asset(String name, int size, String path, String owner,
                 boolean hidden, boolean readOnly, Date creationDate, Date modifiedDate, Date accessDate){
        this.size = size;
        this.name = name;
        this.owner = owner;
        this.path = path;
        this.readOnly = readOnly;
        this.hidden = hidden;
        this.creationDate = creationDate;
        this.accessDate = accessDate;
        this.modifiedDate = modifiedDate;
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

    /**
     * this method return the true if the asset is hidden
     * @return true if the asset is hidden
     * */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * this method return the true if the asset is read only
     * @return true if the asset is read Only
     * */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * this method return the creation date
     * @return Date creation
     * */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * this method return modified Date
     * @return Date modified
     * */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * this method return access date
     * @return access Date
     * */
    public Date getAccessDate() {
        return accessDate;
    }
}
