package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@RequiredArgsConstructor
public class ImageFile {
    private final MultipartFile filePart;
    private final String fileName;

    public final static String FILE_PATH = "/home/ubuntu/cartoonize/src/main/resources/static/images/";

    public void register() {
        File file = new File(FILE_PATH + fileName + ".png");
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath() {
        return FILE_PATH;
    }

    public String getFileName() {
        return fileName;
    }
}
