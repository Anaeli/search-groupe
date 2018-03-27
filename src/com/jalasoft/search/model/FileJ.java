/*
 * Search .java
 *
 * Copyright (c) 2018 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

package com.jalasoft.search.model;

/**
 * Search is charged of model the files based over the attributes
 * @version  1.0
 * @author Luis Cachi
 */

public class FileJ {
    private String path;
    private String name;
    private int size;

    public FileJ(String path, String name, int size) {
        this.path = path;
        this.name = name;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

}
