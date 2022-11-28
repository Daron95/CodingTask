package com.example.springrest.service;

import com.example.springrest.entity.CSVFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


public interface FileService {
    String saveFile(MultipartFile multipartFile) throws IOException;

    CSVFile getFile(int id);

    String deleteFile(int id);
}
