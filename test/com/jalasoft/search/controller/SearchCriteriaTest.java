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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class SearchCriteriaTest {

    @Test
    public void validateReturnFileNameInformation(){
        SearchCriteria criteria = new SearchCriteria();
        criteria.setFileName("text1.txt");
        assertEquals("text1.txt", criteria.getFileName());
    }

    @Test
    public void validateReturnPathInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setPath("test_files");
        assertEquals("test_files", searchCriteria.getPath());
    }

    @Test
    public void validateUpdateFileNameInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setFileName("text2.txt");
        assertEquals("text2.txt", searchCriteria.getFileName());
    }

    @Test
    public void validateUpdatePathInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setPath("test_path");
        assertEquals("test_path", searchCriteria.getPath());
    }

    @Test
    public void validateReturnFileExtensionInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setPath("test_files");
        searchCriteria.getPath();
        assertEquals("test_files", searchCriteria.getPath());
    }

    @Test
    public void validateUpdateFileExtensionInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setExtension("txt");
        assertEquals("txt", searchCriteria.getExtension());
    }
    @Test
    public void validateUpdateHiddenFileInformation(){
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setHidden(true);
        assertTrue(searchCriteria.getHidden());

        searchCriteria.setHidden(false);
        assertFalse( searchCriteria.getHidden());
    }
}
