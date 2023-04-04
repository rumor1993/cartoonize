package com.rumor.lab.infra.controller;

import com.rumor.lab.appilcation.service.CartoonService;
import com.rumor.lab.domain.CartoonFile;
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
    public CartoonFile cartoon(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        return cartoonService.cartoonize(file, fileName);
    }

}
