package com.jalasoft.search.model;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class SearchTest {

    @Test
    public void verifyThisFileDoesnExist(){
        String fileName = "d:\\prueba\\prueba.txt";
        Search search = new Search(fileName);
        assertFalse(search.ExistPath());
    }

    @Test
    public void verifyThisFileExist(){
        String fileName = "c:\\users\\";
        Search search = new Search(fileName);
        assertTrue(search.ExistPath());
    }

    @Test
    public void verifyThisIsFolderFile(){
        String fileName = "c:\\users\\";
        Search search = new Search(fileName);
        assertTrue(search.isDirectory());
    }

    @Test
    public void verifyThisIsFile(){
        String fileName = "c:\\Windows\\WindowsUpdate.txt";
        Search search = new Search(fileName);
        //assertTrue(search.isFile());
    }
}
