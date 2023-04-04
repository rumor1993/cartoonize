package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartoonImageFile {
    private final ImageFile imageFile;

    public String getResourcePath() {
        return "/images/" + imageFile.getFileName();
    }
}
