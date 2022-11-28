package com.example.springrest.controller;

import com.example.springrest.entity.CSVFile;
import com.example.springrest.entity.FileChecker;
import com.example.springrest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    FileService fileService;
    @Autowired
    FileChecker fileChecker;

    @PostMapping("/uploadfile")
    public String uploadFile(@RequestParam("File") MultipartFile file) throws IOException {

        // check if the file is CSV type

        if (!fileChecker.checkCsvType(file)) {
            return "The file is not CSV type";
        }
        return fileService.saveFile(file);

    }

    @GetMapping("/getfile")
    public CSVFile getFile(@RequestParam int id) {

        return fileService.getFile(id);
    }

    @DeleteMapping("/deletefile")
    public String deleteFile(@RequestParam int id) {

        return fileService.deleteFile(id);
    }
}
