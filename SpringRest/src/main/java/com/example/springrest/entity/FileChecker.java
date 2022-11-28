package com.example.springrest.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileChecker {

    public String getFileExtension(MultipartFile file) {

        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        return name.substring(lastIndexOf);
    }

    public boolean checkCsvType(MultipartFile file) {
        String type = getFileExtension(file);
        return type.equals(".csv");
    }
}
