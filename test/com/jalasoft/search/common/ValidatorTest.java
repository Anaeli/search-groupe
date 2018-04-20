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

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static junit.framework.TestCase.*;

public class ValidatorTest {
    private Validator validator;

    @Test
    public void fileNameCorrect(){
        validator = new Validator();
        assertTrue(validator.isFileNameCorrect("filename"));
    }

    @Test
    public void fileNameIncorrect(){
        validator = new Validator();
        assertFalse(validator.isFileNameCorrect("fil;ename/"));
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

    @Test
    public void validateFileCorrect(){
        validator = new Validator();
        assertTrue(validator.isFileCorrect("filename"));
    }

    @Test
    public void validateFileIncorrect(){
        validator = new Validator();
        assertFalse(validator.isFileCorrect("fil;ename/"));
    }

    @Test
    public void validatePathIncorrect(){
        validator = new Validator();
        assertFalse(validator.validPath("fil;ename/"));
    }

    @Test
    public void validateDateCorrect(){
        validator = new Validator();
        Date date = Calendar.getInstance().getTime();
        assertTrue(validator.isValidDate(date));
    }

    @Test
    public void validateDateFromIsEqualDateFrom(){
        validator = new Validator();
        Date dateFrom = Calendar.getInstance().getTime();
        Date dateTo = Calendar.getInstance().getTime();
        assertTrue(validator.dateFromIsLessThanTo(dateFrom, dateTo));
    }

    @Test
    public void validateDateFromIsLessDateFromCorrect() throws ParseException {
        validator = new Validator();
        String dateString = "January 2, 2010";
        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date dateFrom = dateFormat.parse(dateString);
        Date dateTo = Calendar.getInstance().getTime();
        assertTrue(validator.dateFromIsLessThanTo(dateFrom, dateTo));
    }

    @Test
    public void validateDateFromIsLessDateFromIncorrect() throws ParseException {
        validator = new Validator();
        String dateString = "January 2, 2040";
        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date dateFrom = dateFormat.parse(dateString);
        Date dateTo = Calendar.getInstance().getTime();
        assertFalse(validator.dateFromIsLessThanTo(dateFrom, dateTo));
    }
}
