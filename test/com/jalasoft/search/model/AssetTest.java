/*
 * AssetTest.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with Jalasoft.
 */
package com.jalasoft.search.model;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AssetTest {
    Asset asset;

    public AssetTest() {
        Date creationDate = Calendar.getInstance().getTime();
        Date modifiedDate = Calendar.getInstance().getTime();
        Date accessDate = Calendar.getInstance().getTime();
        asset = new Asset("Filename", 77, "C://path", "groupE", true, false,
                creationDate, modifiedDate, accessDate);
    }

    /**
     * File size attribute get test
     */
    @Test
    public void validateGetFileSizeInformation(){
        assertEquals(77, asset.getSize());
    }

    /**
     * File name attribute get test
     */
    @Test
    public void validateGetFileNameInformation(){
        assertEquals("Filename", asset.getName());
    }

    /**
     * File path attribute get  test
     */
    @Test
    public void validateGetPathInformation(){
        assertEquals("C://path", asset.getPath());
    }

    /**
     * Owner attribute get test
     */
    @Test
    public void validateGetOwnerInformation(){
        assertEquals("groupE", asset.getOwner());
    }

    /**
     * File hidden attribute get test
     */
    @Test
    public void validateGetHiddenFileInformation(){
        assertTrue(asset.isHidden());
    }

    /**
     * File read only attribute ReadOnly/Not read only/both get test
     */
    @Test
    public void validateGetReadOnlyFileInformation(){
        assertFalse(asset.isReadOnly());
    }

    /**
     * Created date file attribute get test
     */
    @Test
    public void validateGetCreatedDateFileInformation(){
        Date date = Calendar.getInstance().getTime();
        assertEquals(date, asset.getCreationDate());
    }

    /**
     * Modified date file attribute get test
     */
    @Test
    public void validateGetModifiedDateFileInformation(){
        Date date = Calendar.getInstance().getTime();
        assertEquals(date, asset.getModifiedDate());
    }

    /**
     * Accessed date file attribute get test
     */
    @Test
    public void validateUpdateAccessedDateToFileInformation(){
        Date date = Calendar.getInstance().getTime();
        assertEquals(date, asset.getAccessDate());
    }
}
