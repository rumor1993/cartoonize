package com.rumor.lab.cartoon.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
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
            // 이미지 읽어오기
            BufferedImage inputImage = ImageIO.read(new File(this.staticResourceLocations + this.fileName + "." + this.fileExtension));

            // 이미지 크기를 256x256으로 조정
            BufferedImage outputImage = resize(inputImage, 256, 256);

            // JPEG 포맷으로 변경하여 출력 이미지 저장
            save(outputImage, this.staticResourceLocations + this.fileName + ".jpg" , "jpg");
        } catch (Exception e) {
            log.error("save error ", e.getMessage());
        }
    }


    private BufferedImage resize(BufferedImage inputImage, int targetWidth, int targetHeight) {
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, inputImage.getType());
        outputImage.getGraphics().drawImage(inputImage.getScaledInstance(targetWidth, targetHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);
        return outputImage;
    }

    private void save(BufferedImage outputImage, String outputImagePath, String formatName) throws IOException {
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

    public String getFileFullName() {
        return this.fileName + "." + this.fileExtension;
    }

    public String getResourcePath() {
        return this.staticResourceLocations + this.fileName + ".jpg";
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
