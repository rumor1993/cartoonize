package com.rumor.lab.infra.controller;

import com.rumor.lab.appilcation.service.CartoonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class CartoonController {

    private final CartoonService cartoonService;

    @PostMapping("/cartoon")
    public void cartoon(@RequestParam("file") MultipartFile file, @RequestParam("fileName") String fileName) {
        cartoonService.cartoonize(file, fileName);
    }

}
