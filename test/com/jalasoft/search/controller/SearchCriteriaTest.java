package com.jalasoft.search.controller;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SearchCriteriaTest {

    @Test
    public void validateReturnFileNameInformation(){
        SearchCriteria searchCriteria = new SearchCriteria("text1.txt", "test_files");
        searchCriteria.getFileName();
        assertEquals("text1.txt", searchCriteria.getFileName());
    }

    @Test
    public void validateReturnPathInformation(){
        SearchCriteria searchCriteria = new SearchCriteria("text1.txt", "test_files");
        searchCriteria.getPath();
        assertEquals("test_files", searchCriteria.getPath());
    }

    @Test
    public void validateUpdateFileNameInformation(){
        SearchCriteria searchCriteria = new SearchCriteria("text1.txt", "test_files");
        searchCriteria.setFileName("text2.txt");
        assertEquals("text2.txt", searchCriteria.getFileName());
    }

    @Test
    public void validateUpdatePathInformation(){
        SearchCriteria searchCriteria = new SearchCriteria("text1.txt", "test_files");
        searchCriteria.setPath("test_path");
        assertEquals("test_path", searchCriteria.getPath());
    }
}
