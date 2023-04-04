package com.rumor.lab.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartoonFile {
    private final ImageFile imageFile;

    public String getCartoonFilePath() {
        return null;
    }
}
