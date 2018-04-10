package com.jalasoft.search.model;

import java.io.File;

public abstract class  FactoryAsset {

    /**
     * this method are changer to return the asset object created
     * @param asset the File object from where we get the values
     * @param type The Type passed as string
     * */
    public static Asset createAssets(String type, File asset){

        String tempName = asset.getName();
        String tempPath = asset.getPath();
        int tempSize = (int) asset.length();
        boolean hidden = asset.isHidden();
        boolean readOnly = !asset.canWrite();
        String tempOwner = "";
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
     * this method are changer to return the file extension
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
