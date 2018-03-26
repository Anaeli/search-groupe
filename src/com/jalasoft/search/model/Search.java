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
    private static String namefile = "a";
    private File file;


    public Search() {
        file = new File(path);
    }

    /**
     * this method are changer to evaluate if the path exist
     * */
    private boolean existPath(){

        return file.exists();
    }

    /**
     * this method are charged to evaluate if the path is file
     * */
    private boolean isFile(){
        return file.isFile();
    }

    /**
     * this method are charged to evaluate if the path is a Directory
     * */
    private boolean isDirectory(){

        return file.isDirectory();
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
     * this method are charged to return all files content into a path
     * this are returned into an array in strings
     * */
    private String[] allContentListInString(){
        if(isDirectory())
        return file.list();
        return null;
    }

    /**
     * this method are charged to return all files content into a path
     * this are returned into an array in file array
     * */
    private File[] allContentInFile(){
        if(isDirectory()){
            return file.listFiles();
        }
        return null;
    }

    /**
     * this method are charged to return the file length in bytes
     * */
    private void getSizeInbytes(){

        System.out.println(file.length());
    }

    /**
     * this method are charged to return the file based into a name
     * */
    public ArrayList<File> searchBasedOnNameCriteria(){
        ArrayList listres = new ArrayList();
        File[] allFiles = allContentInFile();
        for (File f: allFiles) {
            if (f.getName().contains(namefile) ){
                listres.add(f);
            }
        }
        return listres;
    }
}
