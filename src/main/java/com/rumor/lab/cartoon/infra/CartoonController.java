package com.rumor.lab.cartoon.infra;

import com.rumor.lab.cartoon.appilcation.service.CartoonService;
import com.rumor.lab.cartoon.infra.response.CartoonImageFile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class CartoonController {

    private final CartoonService cartoonService;

    @PostMapping("/cartoon")
    public CartoonImageFile cartoon(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        return cartoonService.cartoonize(file, fileName);
    }

}
