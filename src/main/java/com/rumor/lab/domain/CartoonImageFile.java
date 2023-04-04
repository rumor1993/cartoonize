package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;

import static com.rumor.lab.utils.PythonExecution.FILE_SAVE_EXTENSION;

@RequiredArgsConstructor
public class CartoonImageFile {
    private final ImageFile imageFile;

    public String getCartoonImagePath() {
        return "/images/" + imageFile.getFileName() + FILE_SAVE_EXTENSION;
    }
}
