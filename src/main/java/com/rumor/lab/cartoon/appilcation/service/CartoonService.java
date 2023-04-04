package com.rumor.lab.cartoon.appilcation.service;

import com.rumor.lab.cartoon.domain.Cartoon;
import com.rumor.lab.cartoon.infra.response.CartoonImageFile;
import com.rumor.lab.cartoon.domain.ImageFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CartoonService {

    private final Cartoon cartoon;
    @Value("${spring.web.resources.static-locations}")
    public final String staticResourceLocations;

    public CartoonImageFile cartoonize(MultipartFile file, String fileName) {
        ImageFile imageFile = new ImageFile(file, fileName, staticResourceLocations);
        imageFile.register();

        CartoonImageFile cartoonImageFile = cartoon.cartoonize(imageFile);
        return cartoonImageFile;
    }

}
