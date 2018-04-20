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

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HelperTest {
    private Helper helper;

    @Test
    public void validateStringConversionToInt(){
        helper = new Helper();
        assertEquals(123, helper.convertStringToInt("123"));
    }

    @Test
    public void validateConvertKBtoBytes(){
        helper = new Helper();
        assertEquals(2000, helper.convertToBytes(2, 0));
    }

    @Test
    public void validateConvertMBtoBytes(){
        helper = new Helper();
        assertEquals(4000000, helper.convertToBytes(4, 1));
    }

    @Test
    public void validateConvertGBtoBytes(){
        helper = new Helper();
        assertEquals(1073741824 , helper.convertToBytes(1, 2));
    }
}
