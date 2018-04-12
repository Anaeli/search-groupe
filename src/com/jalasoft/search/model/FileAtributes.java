package com.jalasoft.search.model;

import java.io.File;

public class FileAtributes {
    private File f;

    public FileAtributes(File f) {
        this.f = f;
    }

    public String getName(){
        return f.getName();
    }

    public long getSize(){
        return (int) f.length();
    }
}
