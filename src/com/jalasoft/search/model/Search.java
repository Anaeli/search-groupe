package com.jalasoft.search.model;

import java.io.File;
import java.io.IOException;

public class Search {

    private static String path = "C:\\testfile";
    private static String namefile = "\\hola.txt";
    private File file;

    public Search(String fileName) {
        this.path=fileName;
        file = new File(path);
    }

    public boolean ExistPath(){
        return file.exists();
    }
    public boolean isFile(){
        return file.isFile();
    }
    public boolean isDirectory(){
        return file.isDirectory();
    }

    public String getExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
