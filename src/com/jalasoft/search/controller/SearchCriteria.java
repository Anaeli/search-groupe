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

import java.util.Date;

import static com.jalasoft.search.common.Log.getInstance;

/*
 * Class to manage criteria for search files or folder
 * @version  1.0
 * @author Eliana Navia
 */
public class SearchCriteria {
    private String fileName;
    private String path;
    private String extension;
    private int isHidden;
    private int type;
    private String owner;
    private int readOnly;
    private int sizeMax;
    private int sizeMin;
    private Date modifiedDate;
    private Date createdDate;
    private Date accessedDate;

    /**
     * Constructor method
     */
    public SearchCriteria(){
    }

    /**
     * Method to return the file name
     * @return file name
     */
    public String getFileName() {
        getInstance().getLogger().info("Filename: " + fileName);
        return fileName;
    }

    /**
     * Method to return the path
     * @return path
     */
    public String getPath() {
        getInstance().getLogger().info("Path: " + path);
        return path;
    }

    /**
     * Method to return the path
     * @return type file
     */
    public int getType() {
        getInstance().getLogger().info("type: " + type);
        return type;
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

    /**
     * Method to get file extension
     * @return file extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Method to get if a file is hidden or not
     * @return true if the file is hidden otherwise false
     */
    public int getHidden() {
        return isHidden;
    }

    /**
     * Method to set file extension
     * @param extension, file extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Method to set if a file is hidden or not
     * @param hidden, true if the file is hidden otherwise false
     */
    public void setHidden(int hidden) {
        isHidden = hidden;
    }

    /**
     * Method to set if a file is hidden or not
     * @param type, true if the file is hidden otherwise false
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Method to set owner criteria to search
     * @param owner criteria to search
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Method to get owner criteria to search
     * @return owner criteria to search
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Method to get hidden criteria to search
     * @return hidden criteria to search
     */
    public int getIsHidden() {
        return isHidden;
    }

    /**
     * Method to get read only criteria to search
     * @return read only criteria to search
     */
    public int getReadOnly() {
        return readOnly;
    }

    /**
     * Method to get size max criteria to search
     * @return size max criteria to search
     */
    public int getSizeMax() {
        return sizeMax;
    }

    /**
     * Method to get size min criteria to search
     * @return size min criteria to search
     */
    public int getSizeMin() {
        return sizeMin;
    }

    /**
     * Method to get modified date criteria to search
     * @return modified date criteria to search
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Method to get created date criteria to search
     * @return created date criteria to search
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Method to get accessed date criteria to search
     * @return accessed date criteria to search
     */
    public Date getAccessedDate() {
        return accessedDate;
    }

    /**
     * Method to set hidden criteria to search
     * @param isHidden int value send from UI
     */
    public void setIsHidden(int isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * Method to get read only criteria to search
     * @param readOnly value send from UI
     */
    public void setReadOnly(int readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Method to set max size criteria to search
     * @param sizeMax value send from UI
     */
    public void setSizeMax(int sizeMax) {
        this.sizeMax = sizeMax;
    }

    /**
     * Method to set min size criteria to search.
     * @param sizeMin value send from UI
     */
    public void setSizeMin(int sizeMin) {
        this.sizeMin = sizeMin;
    }

    /**
     * Method to set modified date criteria to search
     * @param modifiedDate value send from UI
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * Method to set created date criteria to search
     * @param createdDate value send from UI
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Method to set accessed date criteria to search
     * @param accessedDate value send from UI
     */
    public void setAccessedDate(Date accessedDate) {
        this.accessedDate = accessedDate;
    }
}
