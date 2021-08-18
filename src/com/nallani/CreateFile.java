package com.nallani;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

    public void createFileAndWrite(String value) throws Exception {

        if (value == null && value.isEmpty()){
            throw new Exception("value is empty");
        }

        File fileName = new File("registation-data.txt");

        if (fileName.createNewFile()) {

            System.out.println("File has been created.");
        } else {

            System.out.println("File already exists.");
        }

        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(value);
        bw.newLine();
        bw.close();
    }
}
