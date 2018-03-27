/*
 * Search .java
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

import java.io.File;
import java.util.ArrayList;

/**
 * Search is charged of look for the files based over a criteria
 * @version  1.0
 * @author Luis Cachi
 */

public class Search {

    private static String path = "C:\\testfile";
    private static String nameFile = "h";

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
     * */
    private boolean isDirectory(File file){

        return file.isDirectory();
    }

    /**
     * this method are charged return the results using as parameters the attributes
     * */
    public ArrayList<FileJ> getResults(){

        ArrayList<FileJ> res = listAllFilesInPath(this.path);
        if(nameFile != null){
            res = searchBasedOnNameCriteria(nameFile,res);
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
     * this method are charged to return the file based into a name
     * */
    private ArrayList<FileJ> searchBasedOnNameCriteria(String nameToSearch, ArrayList<FileJ> listToSearch){

        ArrayList<FileJ> listres = new ArrayList();
        for (FileJ f: listToSearch) {
            if (f.getName().contains(nameToSearch) ){
                listres.add(f);
            }
        }
        return listres;
    }

    /**
     * this method are charged to return all files content into a path
     * this are returned into an array in file array
     * */
    private ArrayList<FileJ> listAllFilesInPath(String path){

        ArrayList <FileJ> allFilesInFolderList = new ArrayList<>();
        File files = new File(path);
        if(files.exists())
        listFilesForFolder(files, allFilesInFolderList);
        return allFilesInFolderList;
    }

    /**
     * this method are charged fill the array using fileJ
     * */
    private static void listFilesForFolder(File folder , ArrayList<FileJ> res) {

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                String tempName = fileEntry.getName();
                String tempPath = fileEntry.getAbsolutePath();
                FileJ fileJ = new FileJ(tempPath,tempName,0);
                res.add(fileJ);
                listFilesForFolder(fileEntry, res);
            } else {
                if (fileEntry.isFile()) {
                    String tempName = fileEntry.getName();
                    String tempPath = folder.getAbsolutePath();
                    int tempSize = (int) fileEntry.length();
                    FileJ fileJ = new FileJ(tempPath,tempName,tempSize);
                    res.add(fileJ);
                }
            }
        }
    }

}
