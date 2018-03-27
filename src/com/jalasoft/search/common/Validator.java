/*
 * Validator .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.common;
/*
* Class to manage validations related to files
* @version  1.0
* @author Eliana Navia
*/
public class Validator {

    public Validator() {
    }

    /*
    * Method to validate that a file name has valid characters.
     */
    public boolean isFileNameValid(String filename) {
        return filename.matches("^[^<>:;,?\"*|/]+$");
    }
}
