package com.example.springrest.service;

import com.example.springrest.entity.CSVFile;
import com.example.springrest.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;


@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    public String saveFile(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        CSVFile csvFile = new CSVFile(fileName, file.getBytes());
        fileRepository.save(csvFile);
        return "Saved!";
    }

    public CSVFile getFile(int id) {

        Optional<CSVFile> file = fileRepository.findById(id);
        if (file.isPresent()) {
            return file.get();
        }
        return null;
    }

    public String deleteFile(int id) {
        fileRepository.deleteById(id);
        return "Removed!";
    }
}
