package com.java.bootjsonvalidator.service.impl;

import com.java.bootjsonvalidator.dto.filter.FileStatusType;
import com.java.bootjsonvalidator.service.FileService;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public void readFile(String fileData, String filename) {
        try{
            logger.info("Got filename : {}", filename);
            validateFile(fileData,filename);
        }catch (Exception e){
            logger.error("Error while reading json file as resource file. " + e.getMessage());
        }
    }

    @Override
    public boolean validateFile(String fileData, String filename) {
        StringBuilder errorDescription = new StringBuilder();
        FileStatusType fileStatusType = fileStatusValidation(fileData,filename,errorDescription);
        if(fileStatusType != null){
            logger.info("File Status: {} ", fileStatusType );
        }
        return false;
    }

    public FileStatusType fileStatusValidation(String fileData, String filename, StringBuilder errorDescription){

        if(!StringUtils.hasLength(fileData) || fileData.equals("{}")){
            errorDescription.append("Invalid Empty File");
            return FileStatusType.INVALID_EMPTY;
        }else{
            try{
                JSONObject baseJson = new JSONObject(fileData);

                //Check for invalid user
                if(!checkUser(baseJson)){
                    return FileStatusType.INVALID_USER;
                }
            }catch (JSONException e){
                logger.info("File: {} has invalid json format:  ", filename);
                errorDescription.append("Corrupted json file");
                return FileStatusType.INVALID_FILE;
            }catch (Exception e){
                logger.error("Exception occured while json file validation. {} ", e.getMessage());
            }
        }
        return FileStatusType.TEST;
    }

    private boolean checkUser(JSONObject json){
        try{
            String name = json.getJSONObject("user").getJSONObject("profile").getString("name");
            if(name.isEmpty()){
                return false;
            }
            return true;
        }catch (Exception e){
            logger.error("Error getting value for name: {} ", e.getMessage());
            return false;
        }

    }

}
