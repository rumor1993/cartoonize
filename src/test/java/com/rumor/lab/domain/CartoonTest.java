package com.rumor.lab.domain;

import com.rumor.lab.utils.PythonExecution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class CartoonTest {

    @Autowired
    public PythonExecution pythonExecution;

    /**
     * 1. 이미지를 만화화 해라 (FILE)
     *  1.1. 이미지를 저장해라
     *  1.2. 파이썬을 실행해라 (PYTHON)
     *  1.3. 이미지를 반환하라 (FILE)
     */

    @Test
    @DisplayName("이미지를 등록하라")
    public void cartoonize() {
        // 이미지 파일을 저장하라
//        ImageFile imageFile = new ImageFile();
//        imageFile.register();
//
//        // 이미지를 만화화 해라
//        Cartoon cartoon = new Cartoon();
//        CartoonFile cartoonFile = cartoon.cartoonize(imageFile);
    }
}