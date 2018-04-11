/*
 * Validator.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.common;

import java.io.File;
import java.io.IOException;
import static com.jalasoft.search.common.Log.getInstance;

/*
* Class to manage validations related to files
* @version  1.0
* @author Eliana Navia
*/
public class Validator {

    /**
     * Constructor method to validate UI entries
     */
    public Validator() {  }

    /**
     * Method to validate that a file name has valid characters in its name.
     *
     * @param filename
     * @return true if the filename does not contain a invalid character otherwise false.
     */
    public boolean isFileNameCorrect(String filename) {
        return filename.matches("^[^<>:;,?\"*|/]+$");
    }

    /**
     * Method to validate that the path exist.
     * @param path
     * @return true if the path exist otherwise false.
     */
    public boolean fileExist(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Method to validate the file according the current OS rules.
     * @param file
     * @return true if the string contains valid arguments otherwise false.
     */
    public boolean isFileNameValid(String file) {
        File f = new File(file);
        try {
            f.getCanonicalPath();
            return true;
        } catch (IOException e) {
            getInstance().getLogger().error(e.getMessage());
            return false;
        }
    }
}
