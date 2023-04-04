package com.rumor.lab.cartoon.domain;

import com.rumor.lab.cartoon.utils.Properties;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageFile {
    private final MultipartFile filePart;
    private String fileName;
    private String fileExtension;

    public ImageFile(MultipartFile filePart, String fileName) {
        this.filePart = filePart;
        this.fileName = fileName;
        this.fileExtension = this.getFileExtension();
    }

    public void register() {
        File file = new File(Properties.staticResourceLocations + fileName + "." + this.fileExtension);
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileFullName() {
        return this.fileName + "." + this.fileExtension;
    }

    public String getResourcePath() {
        return Properties.staticResourceLocations + this.fileName + "." + this.fileExtension;
    }

    public String getFileExtension() {
        String fileName = this.filePart.getOriginalFilename();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
        } else {
            return "";
        }
    }
}
