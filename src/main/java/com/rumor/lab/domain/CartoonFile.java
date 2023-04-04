package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartoonFile {
    private final ImageFile imageFile;

    public String getCartoonFilePath() {
        return imageFile.getFilePathAndFileName();
    }
}
