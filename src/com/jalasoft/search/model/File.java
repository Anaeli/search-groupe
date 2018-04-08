package com.jalasoft.search.model;

/**
 *This class implements the File for model a Folder object.
 * @version  1.0
 * @author Luis Cachi
 */
public class File extends Asset {
    String extension;

    public File(String name, int size, String path, String owner, String extension) {
        super(name, size, path, owner);
        this.extension = extension;
    }
}
