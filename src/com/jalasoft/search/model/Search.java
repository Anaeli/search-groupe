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
import java.util.ArrayList;

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
     * this method are changer to evaluate if the path exist
     * */
    private boolean existPath(File file){

        return file.exists();
    }

    /**
     * this method are charged to evaluate if the path is file
     * */
    private boolean isFile(File file){

        return file.isFile();
    }

    /**
     * this method are charged to evaluate if the path is a Directory
     * @param file object created with a path
     * @return true is the file is directory or false when not match.
     * */
    private boolean isDirectory(File file){

        return file.isDirectory();
    }

    /**
     * this method are charged return the results using as parameters the attributes
     * @return a list with all files what match with all parameters defined.
     * */
    public ArrayList<Asset> getResults(){

        ArrayList<Asset> res = listAllFilesInPath(searchCriteria.getPath());
        if(searchCriteria.getFileName() != ""){
            res = searchBasedOnNameCriteria(searchCriteria.getFileName(),res);
        }
        if(searchCriteria.getExtension() != ""){
            res = searchBasedOnExtension(searchCriteria.getExtension(),res);
        }
        if(searchCriteria.getHidden() == 1){
            res = getAllHiddenFiles(res);
        }
        if(searchCriteria.getHidden() == 2){
            res = getAllNoHiddenFiles(res);
        }
        if(searchCriteria.getType() == 1){
            res = getAllFolders(res);
        }
        if(searchCriteria.getType() == 2){
            res = getAllFiles(res);
        }
        return res;
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
     * @param ishiden criteria To Search
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnHidden(boolean ishiden, ArrayList<Asset> listToSearch){

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
     * charged to evaluate the files into the list based on the name
     * @param isReadOnly criteria To Search
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<Asset> searchBasedOnIsReadOnly(boolean isReadOnly, ArrayList<Asset> listToSearch){

        ArrayList<Asset> listRes = new ArrayList();
        for (Asset f: listToSearch) {
            if (f.isReadOnly()){
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
    private ArrayList<FileSearch> seachBasedOnSize(int max, int min, ArrayList<FileSearch> listSearch){

        ArrayList<FileSearch> listResult = new ArrayList();
        for (FileSearch f: listSearch) {
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
        if(files.exists() && files.isDirectory())
            listFilesForFolder(files, allFilesInFolderList);
        return allFilesInFolderList;
    }

    /**
     * this method is charged fill the array using fileJ this only is called from
     * listAllFilesInPath method
     * @param folder this Param is a File object with the path setup
     * @param res is an ArrayList of FileSearch what is filled the this method
     * */
    private void listFilesForFolder(File folder , ArrayList<Asset> res) {

        for (File fileEntry : folder.listFiles()) {
            String owner = "";
            Asset asset;
            try {
                owner = Files.getOwner(fileEntry.toPath()).getName();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (fileEntry.isDirectory()) {
                asset = FactoryAsset.createAssets("folder",fileEntry, owner);
                listFilesForFolder(fileEntry, res);
            } else if (fileEntry.isFile()){
                asset = FactoryAsset.createAssets("file", fileEntry, owner);
            }else{
                asset = FactoryAsset.createAssets("other", fileEntry, owner);
            }
            res.add(asset);
        }
    }

    /**
     * this method Set the SearchCriteria Object
     * @param searchCriteria object
     * */
    public void setSearchCriteria(SearchCriteria searchCriteria){
        this.searchCriteria = searchCriteria;
    }

}
