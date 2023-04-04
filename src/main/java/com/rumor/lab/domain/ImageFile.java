package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;
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

    public final static String FILE_PATH = "/home/ubuntu/cartoonize/src/main/resources/static/images/";

    public void register() {
        File file = new File(FILE_PATH + fileName + "." + this.fileExtension);
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileFullName() {
        return this.fileName + "." + fileExtension;
    }

    public String getResourcePath() {
        return this.FILE_PATH + this.fileName + "." + this.fileExtension;
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
