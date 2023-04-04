package com.rumor.lab.domain;

import com.rumor.lab.utils.PythonExecution;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Cartoon {

    private final PythonExecution pythonExecution;

    public CartoonImageFile cartoonize(ImageFile imageFile) {
        // 파이썬을 실행하라
        Boolean isExecuted = pythonExecution.excute(imageFile);

        if (!isExecuted) {
            throw new RuntimeException("cartoonize Error");
        }

        // 카툰 파일 전달
        return new CartoonImageFile(imageFile);
    }
}
