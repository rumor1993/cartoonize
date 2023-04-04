package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartoonImageFile {
    private final ImageFile imageFile;

    public String getCartoonImagePath() {
        return "/images/" + imageFile.getFileFullName();
    }
}
