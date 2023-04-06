package com.rumor.lab.cartoon.domain;

import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class ImageFileTest {

    @Test
    @Transactional
    void register() throws IOException {
        // 입력 이미지 경로와 출력 이미지 경로 지정
        String inputImagePath = "/Users/rumor1993/IdeaProjects/lab/src/main/resources/static/images/seed0085_0.8.png";
        String outputImagePath = "/Users/rumor1993/IdeaProjects/lab/src/main/resources/static/images/seed0085_0.8.jpg";

        // 이미지 읽어오기
        BufferedImage inputImage = ImageIO.read(new File(inputImagePath));

        // 이미지 크기를 256x256으로 조정
        BufferedImage outputImage = resize(inputImage, 256, 256);

        // JPEG 포맷으로 변경하여 출력 이미지 저장
        save(outputImage, outputImagePath, "jpg");

    }


    private static BufferedImage resize(BufferedImage inputImage, int targetWidth, int targetHeight) {
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, inputImage.getType());
        outputImage.getGraphics().drawImage(inputImage.getScaledInstance(targetWidth, targetHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);
        return outputImage;
    }

    private static void save(BufferedImage outputImage, String outputImagePath, String formatName) throws IOException {
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }


}