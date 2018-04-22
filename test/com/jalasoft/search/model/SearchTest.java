package com.jalasoft.search.model;

import com.jalasoft.search.controller.SearchCriteria;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertArrayEquals;

public class SearchTest {

    @Test
    public void verifySearchBasedOnPath() throws InterruptedException {
        Search search = new Search();
        SearchCriteria sCriteria = new SearchCriteria();
        sCriteria.setFileName("");
        sCriteria.setPath("C:\\search-groupe");
        search.setSearchCriteria(sCriteria);
        ArrayList<Asset> result = search.getResults();
        assertArrayEquals(result.toArray(), result.toArray());
    }

    @Test
    public void verifySearchBasedOnFile() throws InterruptedException {
        Search search = new Search();
        SearchCriteria sCriteria = new SearchCriteria();
        sCriteria.setFileName("README.md");
        sCriteria.setPath("C:\\search-groupe");
        search.setSearchCriteria(sCriteria);
        ArrayList<Asset> result = search.getResults();
        assertArrayEquals(result.toArray(), result.toArray());
    }

    @Test
    public void verifySearchBasedOnAccessedDate() throws InterruptedException {
        Search search = new Search();
        Date date = Calendar.getInstance().getTime();
        SearchCriteria sCriteria = new SearchCriteria();
        sCriteria.setFileName("");
        sCriteria.setAccessedDateTo(date);
        sCriteria.setPath("C:\\search-groupe");
        search.setSearchCriteria(sCriteria);
        ArrayList<Asset> result = search.getResults();
        assertArrayEquals(result.toArray(), result.toArray());
    }

    @Test
    public void verifySearchBasedOnExtension() throws InterruptedException {
        Search search = new Search();
        SearchCriteria sCriteria = new SearchCriteria();
        sCriteria.setFileName("");
        sCriteria.setExtension("md");
        sCriteria.setPath("C:\\search-groupe");
        search.setSearchCriteria(sCriteria);
        ArrayList<Asset> result = search.getResults();
        assertArrayEquals(result.toArray(), result.toArray());
    }
}
