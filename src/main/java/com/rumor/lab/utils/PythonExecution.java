package com.rumor.lab.utils;

import com.rumor.lab.domain.ImageFile;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class PythonExecution {
    public final static String FILE_SAVE_EXTENSION = ".png";


    public Boolean excute(ImageFile imageFile) {

        try {
            ProcessBuilder python = new ProcessBuilder("python3", "test.py", "--photo_path", imageFile.getResourcePath(), "--save_path", imageFile.getFileName() + FILE_SAVE_EXTENSION);
            python.directory(new File("/home/ubuntu/photo2cartoon/test.py").getParentFile());
            Process process = python.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

            return exitCode == 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }
}
