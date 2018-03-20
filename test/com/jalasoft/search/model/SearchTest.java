package com.jalasoft.search.model;

import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class SearchTest {

    @Test
    public void VerifyThisFileDoesnExist(){
        String fileName = "d:\\prueba\\prueba.txt";
        Search search = new Search(fileName);
        assertFalse(search.ExistPath());
    }


}
