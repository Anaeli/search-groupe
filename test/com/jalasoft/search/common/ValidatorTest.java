/*
 * ValidatorTest.java
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

import org.junit.Test;

import static junit.framework.TestCase.*;

public class ValidatorTest {
    private Validator validator;

    @Test
    public void fileNameValid(){
        validator = new Validator();
        assertTrue(validator.isFileNameCorrect("filename"));
    }

    @Test
    public void fileNameInvalid(){
        validator = new Validator();
        assertFalse(validator.isFileNameCorrect("fil;ename/"));
    }

    @Test
    public void pathExist(){
        validator = new Validator();
        assertTrue(validator.fileExist("D:/search-project/search-groupe/test/com.jalasoft.search/common/test_files/text1.txt"));
    }

    @Test
    public void pathDoesNotExist(){
        validator = new Validator();
        assertFalse(validator.fileExist("notExist"));
    }

    @Test
    public void validateFilenameValid(){
        validator = new Validator();
        assertTrue(validator.isFileNameValid("text1.txt"));
    }

    @Test
    public void validateFilenameInvalid(){
        validator = new Validator();
        assertFalse(validator.isFileNameValid("test.T*T"));
    }
}
