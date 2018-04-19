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
import java.util.Date;

import static com.jalasoft.search.common.Log.getInstance;

/*
* Class to manage validations related to files
* @version  1.0
* @author Eliana Navia
*/
public class Validator {

    Helper helper;

    /**
     * Constructor method to validate UI entries
     */
    public Validator() {
        helper = new Helper();
    }

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

    /**
     * Method to validate if a file entry is correct
     * @param file name input
     * @return true if file has correct parameters otherwise false
     */
    public boolean isFileCorrect(String file) {
        boolean is_correct;
        if (isFileNameCorrect(file)&& isFileNameValid(file)) {
            is_correct = true;
        }else {
            is_correct = false;
        }
        return is_correct;
    }

    public boolean isPathDirection(String pathText) {
        File f = new File(pathText);
        return f.exists();
    }

    public boolean isValidDate(Date date) {
        if(date instanceof Date)
            return true;
        return false;
    }

    public boolean dateFromIsLessThanTo(Date from, Date to) {
        if(from.compareTo(to) <= 0){
            return true;
        }
        return false;
    }

    public boolean isNotEmpty(String num) {
        if (!num.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean minInLessThanMax(int min, int max) {
        if (min <= max){
            return true;
        }
        return false;
    }
}
