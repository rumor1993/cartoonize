package com.rumor.lab.cartoon.domain;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {
    private final MultipartFile filePart;
    private final String fileName;
    private final String staticResourceLocations;
    private final String fileExtension;


    public ImageFile(MultipartFile filePart, String fileName, String staticResourceLocations) {
        this.filePart = filePart;
        this.fileName = fileName;
        this.staticResourceLocations = staticResourceLocations;
        this.fileExtension = this.getFileExtension();
    }

    public void register() {
        try {
            // MultipartFile을 BufferedImage로 변환
            BufferedImage inputImage = ImageIO.read(this.filePart.getInputStream());

            // 이미지 크기를 targetWidth x targetHeight로 조정
            BufferedImage outputImage = Thumbnails.of(inputImage)
                    .size(512, 512)
                    .asBufferedImage();

            // 최적화된 이미지를 저장
            ImageIO.write(outputImage, "jpg", new File(this.getResourcePath()));
        } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public String getFileFullName() {
        return this.fileName + "." + this.fileExtension;
    }

    public String getResourcePath() {
        return this.staticResourceLocations + this.fileName + "." + this.fileExtension;
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
