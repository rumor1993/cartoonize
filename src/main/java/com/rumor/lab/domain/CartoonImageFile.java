package com.rumor.lab.domain;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartoonImageFile {
    public final static String FILE_SAVE_EXTENSION = ".png";

    private final ImageFile imageFile;

    public String getCartoonImagePath() {
        return "/images/" + imageFile.getFileName() + FILE_SAVE_EXTENSION;
    }
}
