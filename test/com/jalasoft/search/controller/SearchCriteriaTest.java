/*
 * SearchCriteriaTest.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.controller;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class SearchCriteriaTest {

    /**
     * Filename attribute get and set test
     */
    @Test
    public void validateUpdateFileNameInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setFileName("text2.txt");
        assertEquals("text2.txt", searchCriteria.getFileName());
    }

    /**
     * path attribute get and set test
     */
    @Test
    public void validateUpdatePathInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setPath("test_path");
        assertEquals("test_path", searchCriteria.getPath());
    }

    /**
     * File extension attribute get and set test
     */
    @Test
    public void validateUpdateFileExtensionInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setExtension("txt");
        assertEquals("txt", searchCriteria.getExtension());
    }

    /**
     * Owner attribute get and set test
     */
    @Test
    public void validateUpdateOwnerInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setOwner("Grupo E");
        assertEquals("Grupo E", searchCriteria.getOwner());
    }

    /**
     * File hidden attribute get and set test
     */
    @Test
    public void validateUpdateHiddenFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setHidden(1);
        assertEquals(1, searchCriteria.getHidden());
    }

    /**
     * Type attribute File/Folder/both  get and set test
     */
    @Test
    public void validateUpdateTypeInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setType(2);
        assertEquals(2, searchCriteria.getType());
    }

    /**
     * File read only attribute ReadOnly/Not read only/both  get and set test
     */
    @Test
    public void validateUpdateReadOnlyFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setReadOnly(0);
        assertEquals(0, searchCriteria.getType());
    }

    /**
     * File size attribute get and set test
     */
    @Test
    public void validateUpdateMaxSizeFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSizeMax(1000);
        assertEquals(1000, searchCriteria.getSizeMax());
    }

    /**
     * File size attribute get and set test
     */
    @Test
    public void validateUpdateMinSizeFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSizeMin(10);
        assertEquals(10, searchCriteria.getSizeMin());
    }

    /**
     * File unit attribute get and set test
     */
    @Test
    public void validateUpdateUnitSizeFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSizeUnit(0);
        assertEquals(0, searchCriteria.getSizeUnit());
    }

    /**
     * Modified date file attribute get and set test
     */
    @Test
    public void validateUpdateModifiedDateFromFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        Date date = Calendar.getInstance().getTime();
        searchCriteria.setModifiedDateFrom(date);
        assertEquals(date, searchCriteria.getModifiedDateFrom());
    }

    /**
     * Modified date file attribute get and set test
     */
    @Test
    public void validateUpdateModifiedDateToFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        Date date = Calendar.getInstance().getTime();
        searchCriteria.setModifiedDateTo(date);
        assertEquals(date, searchCriteria.getModifiedDateTo());
    }

    /**
     * Modified date file attribute get and set test
     */
    @Test
    public void validateUpdateAccessedDateToFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        Date date = Calendar.getInstance().getTime();
        searchCriteria.setAccessedDateTo(date);
        assertEquals(date, searchCriteria.getModifiedDateTo());
    }
}
