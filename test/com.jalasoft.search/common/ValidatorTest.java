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
import com.jalasoft.search.controller.SearchCriteria;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class ValidatorTest {
    private Validator validator;

    @Test
    public void fileNameValid(){
        validator = new Validator();
        assertTrue(validator.isFileNameValid("filename"));
    }

    @Test
    public void fileNameInvalid(){
        validator = new Validator();
        assertFalse(validator.isFileNameValid("fil;ename/"));
    }
}
