/*
 * Search.java
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

import com.jalasoft.search.controller.SearchCriteria;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static com.jalasoft.search.common.Log.getInstance;

/**
 * Search is charged of look for the files based over a criteria
 * @version  1.0
 * @author Luis Cachi
 */

public class Search {

    private SearchCriteria searchCriteria;

    /**
     * Constructor
     */
    public Search() {
    }

    /**
     * this method are charged return the results using as parameters the attributes
     * @return a list with all files what match with all parameters defined.
     * */
    public ArrayList<Asset> getResults() throws InterruptedException {
        ArrayList<Asset> res = listAllFilesInPath(searchCriteria.getPath());
        if(!searchCriteria.getFileName().isEmpty()){
            res = searchBasedOnNameCriteria(searchCriteria.getFileName(), res);
        }
        if(searchCriteria.getExtension() != null){
            res = searchBasedOnExtension(searchCriteria.getExtension(), res);
        }
        if(searchCriteria.getHidden() == 1){
            res = getAllHiddenFiles(res);
        }
        if(searchCriteria.getHidden() == 2){
            res = getAllNoHiddenFiles(res);
        }
        if(searchCriteria.getType() == 2){
            res = getAllFolders(res);
        }
        if(searchCriteria.getType() == 1){
            res = getAllFiles(res);
        }
        if(searchCriteria.getOwner() != null){
            res = searchBasedOnOwnerName(searchCriteria.getFileName(), res);
        }
        if(searchCriteria.getReadOnly() == 1){
            res = getAllReadOnlyFiles(res);
        }
        if(searchCriteria.getReadOnly() == 2){
            res = getAllNoReadOnlyFiles(res);
        }
        if(searchCriteria.getAccessedDateFrom() != null && searchCriteria.getAccessedDateTo() != null){
            res = searchBasedOnAccessDate(searchCriteria.getAccessedDateTo(),searchCriteria.getAccessedDateFrom(), res);
        }
        if(searchCriteria.getModifiedDateFrom() != null && searchCriteria.getModifiedDateTo() != null){
            res = searchBasedOnModifiedDate(searchCriteria.getModifiedDateTo(),searchCriteria.getModifiedDateFrom(), res);
        }
        if(searchCriteria.getCreatedDateFrom() != null && searchCriteria.getCreatedDateTo() != null){
            res = searchBasedOnCreationDate(searchCriteria.getCreatedDateTo(),searchCriteria.getCreatedDateFrom(), res);

        }
        if(searchCriteria.getSizeMax() >= 0 && searchCriteria.getSizeMin() >= 0){
            res = searchBasedOnSize(searchCriteria.getSizeMax(),searchCriteria.getSizeMin(), res);
        }else{
            getInstance().getLogger().error("no allowed search with 0 values");
        }
        return res;
    }

    /**
     * charged to evaluate the files into the list based on a range of access date
     * @param max, min is a criteria To Search by date
     * @param listSearch where is searched the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnAccessDate (Date max, Date min, ArrayList<Asset> listSearch){
        ArrayList<Asset> listResult = new ArrayList();
        for (Asset f: listSearch) {
            if (min.compareTo(f.getAccessDate()) <= 0 && max.compareTo(f.getAccessDate()) >= 0)
                listResult.add(f);
        }
        return listResult;
    }

    /**
     * charged to evaluate the files into the list based on a range of modified date
     * @param max, min is a criteria To Search by date
     * @param listSearch where is searched the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnModifiedDate (Date max, Date min, ArrayList<Asset> listSearch){
        ArrayList<Asset> listResult = new ArrayList();
        for (Asset f: listSearch) {
            if (min.compareTo(f.getModifiedDate()) <= 0 && max.compareTo(f.getModifiedDate()) >= 0)
                listResult.add(f);
        }
        return listResult;
    }

    /**
     * charged to evaluate the files into the list based on a range of creation date
     * @param max, min is a criteria To Search by date
     * @param listSearch where is searched the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnCreationDate (Date max, Date min, ArrayList<Asset> listSearch){
        ArrayList<Asset> listResult = new ArrayList();
        for (Asset f: listSearch) {
            if (min.compareTo(f.getCreationDate()) <= 0 && max.compareTo(f.getCreationDate()) >= 0)
                listResult.add(f);
        }
        return listResult;
    }

    /**
     * This method return a list of all Read Only  Files
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> getAllReadOnlyFiles (ArrayList<Asset> listToSearch) {
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f.isReadOnly()){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * This method return a list of all no Read Only  Files
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> getAllNoReadOnlyFiles (ArrayList<Asset> listToSearch) {
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (!f.isReadOnly()){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * This method return a list of all no Hidden Files
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> getAllNoHiddenFiles(ArrayList<Asset> listToSearch) {
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (!f.isHidden()){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * This method return a list of all Hidden Files
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> getAllHiddenFiles(ArrayList<Asset> listToSearch) {
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f.isHidden()){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * charged to evaluate the files into the list based on the name
     * @param nameToSearch criteria To Search
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnNameCriteria(String nameToSearch, ArrayList<Asset> listToSearch){

        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f.getName().contains(nameToSearch) ){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * charged to evaluate the files into the list based on the name
     * @param nameToSearch criteria To Search
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnOwnerName(String nameToSearch, ArrayList<Asset> listToSearch){
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f.getOwner().contains(nameToSearch) ){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * charged to evaluate the files into the list based on the name
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> getAllFiles(ArrayList<Asset> listToSearch){
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f instanceof FileSearch){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * charged to evaluate the files into the list based on the name.
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> getAllFolders(ArrayList<Asset> listToSearch){
        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f instanceof Folder){
                listRes.add(f);
            }
        }
        return listRes;
    }

    /**
     * charged to evaluate the files into the list based on the extension
     * @param extension is a criteria To Search
     * @param listSearch where is searched the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnExtension(String extension, ArrayList<Asset> listSearch){
        ArrayList<Asset> listResult = new ArrayList();
        for (Asset f: listSearch) {
            if (f.getName().contains(extension) ){
                listResult.add(f);
            }
        }
        return listResult;
    }

    /**
     * charged to evaluate the files into the list based on size
     * @param max, min is a criteria To Search by size
     * @param listSearch where is searched the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnSize(int max, int min, ArrayList<Asset> listSearch){
        ArrayList<Asset> listResult = new ArrayList();
        for (Asset f: listSearch) {
            int size = f.getSize();
            if (max >= size && min <= size ){
                listResult.add(f);
            }
        }
        return listResult;
    }

    /**
     * this method is charged to return all files content into a path
     * this are returned into an array in file array
     * @param path to create the File
     * @return arraylist with all files and folder what are content in the path
     * */
    private ArrayList<Asset> listAllFilesInPath(String path){
        ArrayList <Asset> allFilesInFolderList = new ArrayList<>();
        File files = new File(path);
        if (files.isDirectory()){
            listFilesForFolder(files, allFilesInFolderList);
            }
        return allFilesInFolderList;
    }

    /**
     * this method is charged fill the array using fileJ this only is called from
     * listAllFilesInPath method
     * @param folder this Param is a File object with the path setup
     * @param res is an ArrayList of FileSearch what is filled the this method
     * @return true if finished  */
    private void listFilesForFolder(File folder, ArrayList<Asset> res) {
        for (File fileEntry : folder.listFiles()) {
            String owner = "";
            Asset asset;
            try {
                owner = Files.getOwner(fileEntry.toPath()).getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileEntry.isDirectory()) {
                asset = FactoryAsset.createAssets("folder",fileEntry, owner, getCreationDate(fileEntry));
                res.add(asset);
                listFilesForFolder(fileEntry, res);
            } else {
                asset = FactoryAsset.createAssets("file", fileEntry, owner, getCreationDate(fileEntry));
                res.add(asset);
            }
        }
    }

    /**
     * this method Set the SearchCriteria Object
     * @param searchCriteria object
     * */
    public void setSearchCriteria(SearchCriteria searchCriteria){
        this.searchCriteria = searchCriteria;
    }

    /**
     * this method is charged to get the differents dates that a File or directory has assigned
     * @param file this Param is a File object
     * @return  HashMap is an List with specified keys
     * */
    private HashMap<String, Date> getCreationDate(File file){
        HashMap<String, Date> dates = new HashMap();
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long created = attr.creationTime().to(TimeUnit.MILLISECONDS);
        long modified  = attr.lastModifiedTime().to(TimeUnit.MILLISECONDS);
        long access  = attr.lastAccessTime().to(TimeUnit.MILLISECONDS);
        Date createdDate = new Date(created);
        Date modifiedDate = new Date(modified);
        Date accessDate = new Date(access);
        dates.put("cDate",createdDate);
        dates.put("mDate",modifiedDate);
        dates.put("aDate",accessDate);

        return dates;
    }

}
