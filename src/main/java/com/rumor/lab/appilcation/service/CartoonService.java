package com.rumor.lab.appilcation.service;

import com.rumor.lab.domain.Cartoon;
import com.rumor.lab.domain.CartoonFile;
import com.rumor.lab.domain.ImageFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CartoonService {

    private final Cartoon cartoon;

    public CartoonFile cartoonize(MultipartFile file, String fileName) {
        ImageFile imageFile = new ImageFile(file, fileName);
        imageFile.register();

        CartoonFile cartoonFile = cartoon.cartoonize(imageFile);
        return cartoonFile;
    }

}
