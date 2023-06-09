package com.rumor.lab.cartoon.infra.response;
import com.rumor.lab.cartoon.domain.ImageFile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CartoonImageFile {
    private final ImageFile imageFile;

    public String getFileName() {
        return imageFile.getFileFullName();
    }

    public String getCartoonImagePath() {
        return "/resources/images/" + imageFile.getFileFullName();
    }
}
