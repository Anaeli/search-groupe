/*
 * Asset.java
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

import java.io.File;

/**
 *  The FactoryAsset class should return an asset created from a File.
 *
 * @version  1.0
 * @author Luis Cachi
 */

public class  FactoryAsset {

    /**
     * this method is changer to return the asset object created
     * @param asset the File object from where we get the values
     * @param type The Type passed as string
     * */
    public static Asset createAssets(String type, File asset, String owner){
        String tempName = asset.getName();
        String tempPath = asset.getPath();
        int tempSize = (int) asset.length();
        boolean hidden = asset.isHidden();
        boolean readOnly = !asset.canWrite();
        String tempOwner = owner;
        String extension = getExtension(tempName);
            if (type == "folder") {
                return new Folder(tempName,tempSize,tempPath,tempOwner, asset.listFiles().length,hidden,readOnly);
            } else if(type == "file"){
                return new FileSearch(tempName,tempSize,tempPath,tempOwner,extension,hidden,readOnly);
            }else{
                return new Asset(tempName,tempSize,tempPath,tempOwner,hidden,readOnly);
            }
    }

    /**
     * this method is changed to return the file extension
     * @param fileName this the completed name
     * */
    private static String getExtension(String fileName){

        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
