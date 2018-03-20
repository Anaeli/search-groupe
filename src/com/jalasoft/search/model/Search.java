package com.jalasoft.search.model;

import java.io.File;
import java.io.IOException;

public class Search {

    private static String path = "C:\\testfile";
    private static String namefile = "\\hola.txt";

    public Search(String fileName) {
        this.path=fileName;
    }

    public boolean ExistPath(){
        File files = new File(path);
        return files.exists();
    }

    public static void main(String[]arg) throws IOException {
        File files = new File(path);
        System.out.println("exist this path "+files.exists());
        //File[] fileList = files.listFiles();

//        for (File file: fileList ) {
//            System.out.println(file.getName());
//            System.out.println("is file "+file.isFile());
//            System.out.println("is directory "+ file.isDirectory());
//            System.out.println("fullPath " + file.getCanonicalPath());
//            System.out.println("extension "+ getExtension(file.getName()) );
//            System.out.println(file.exists());
//        }

    }



    public static String getExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
