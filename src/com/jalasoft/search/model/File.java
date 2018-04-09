package com.jalasoft.search.model;

/**
 *This class implements the File for model a Folder object.
 * @version  1.0
 * @author Luis Cachi
 */
public class File extends Asset {
    String extension;

    /**
     * constructor of File Search
     * @param name of where the object found
     * @param size in bites of the object
     * @param path of where the object found
     * @param owner Owner name
     * @param extension that has the file
     * @param readOnly its the file readonly
     * @param hidden  its the file hidden
     * */
    public File(String name, int size, String path, String owner, String extension,
                boolean hidden, boolean readOnly) {
        super(name, size, path, owner, hidden, readOnly);
        this.extension = extension;
    }

    /**
     * this method return the Extension what has the file
     * @return extension of the object
     * */
    public String getExtension() {
        return extension;
    }
}
