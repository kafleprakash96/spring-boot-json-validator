package com.java.bootjsonvalidator.service;

public interface FileService {

    void readFile(String fileData, String filename);

    boolean validateFile(String fileData, String filename);

}
