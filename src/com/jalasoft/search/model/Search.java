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
import java.util.ArrayList;

/**
 * Search is charged of look for the files based over a criteria
 * @version  1.0
 * @author Luis Cachi
 */

public class Search {

    //private static String path = "C:\\testfile";
    //private static String nameFile = "h";
    private SearchCriteria searchCriteria;

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
    public ArrayList<FileSearch> getResults(){


        ArrayList<FileSearch> res = listAllFilesInPath(searchCriteria.getPath());
        if(searchCriteria.getFileName() != null){
            res = searchBasedOnNameCriteria(searchCriteria.getFileName(),res);
        }
        if(searchCriteria.getExtension() != null){
            res = searchBasedOnExtension(searchCriteria.getExtension(),res);
        }
        return res;
    }

    /**
     * this method are changer to return the file extension
     * */
    private String getExtension(String fileName){

        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }

    /**
     * charged to evaluate the files into the list based on the name
     * @param nameToSearch criteria To Search
     * @param listToSearch where is lookfor the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<FileSearch> searchBasedOnNameCriteria(String nameToSearch, ArrayList<FileSearch> listToSearch){

        ArrayList<FileSearch> listres = new ArrayList();
        for (FileSearch f: listToSearch) {
            if (f.getName().contains(nameToSearch) ){
                listres.add(f);
            }
        }
        return listres;
    }

    /**
     * charged to evaluate the files into the list based on the extension
     * @param extension is a criteria To Search
     * @param listSearch where is searched the criteria
     * @return ArrayList with all files what match with the criteria
     * */
    private ArrayList<FileSearch> searchBasedOnExtension(String extension, ArrayList<FileSearch> listSearch){

        ArrayList<FileSearch> listResult = new ArrayList();
        for (FileSearch f: listSearch) {
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
     * this method are charged to return all files content into a path
     * this are returned into an array in file array
     * @param path to create the File
     * @return arraylist with all files and folder what are content in the path
     * */
    private ArrayList<FileSearch> listAllFilesInPath(String path){

        ArrayList <FileSearch> allFilesInFolderList = new ArrayList<>();
        File files = new File(path);
        if(files.exists() && files.isDirectory())
        listFilesForFolder(files, allFilesInFolderList);
        return allFilesInFolderList;
    }

    /**
     * this method are charged fill the array using fileJ this only is called from
     * listAllFilesInPath method
     * @param folder this Param is a File object with the path setup
     * @param res is an ArrayList of FileSearch what is filled the this method
     * */
    private void listFilesForFolder(File folder , ArrayList<FileSearch> res) {

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                String tempName = fileEntry.getName();
                String tempPath = fileEntry.getAbsolutePath();
                FileSearch fileJ = new FileSearch(tempPath,tempName,0,null);
                res.add(fileJ);
                listFilesForFolder(fileEntry, res);
            } else {
                if (fileEntry.isFile()) {
                    String tempName = fileEntry.getName();
                    String tempPath = folder.getAbsolutePath();
                    int tempSize = (int) fileEntry.length();
                    String temExten = getExtension(tempName);
                    FileSearch fileJ = new FileSearch(tempPath,tempName,tempSize,temExten);
                    res.add(fileJ);
                }
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

}
