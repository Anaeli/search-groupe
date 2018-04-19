/*
 * Helper.java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.search.common;

import static com.jalasoft.search.common.Log.getInstance;

/*
 * Helper class to implement utilities to the app
 * @version  1.0
 */
public class Helper {

    // 1 KB = 1000 Byte
    // 1 MB = 1000000 Byte
    // 1 GB = 1.073.741.824 Bytes

    public Helper() {}

    /**
     * Method to convert int numbers according unit(KB, MB, GB) to bytes
     * @param numToConvert
     * @param unit 0 = KB, 1 = MB, 2 = GB
     * @return
     */
    public int convertToBytes(int numToConvert, int unit){
        int bytes = numToConvert;
        if(unit == 0) {
            bytes = numToConvert*1000;
        }else if(unit == 1) {
            bytes = numToConvert*1000;
        } else if(unit == 2) {
            bytes = numToConvert*1073741824;
        }
       return bytes;
    }

    /**
     * Method to convert a string to int
     * @param number on string to convert on int
     * @return int number converted
     */
    public int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }
}
