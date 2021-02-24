package com.company;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("/Users/kwon-ohchul/Desktop/test.txt");
        byte[] data = "ABC".getBytes();

        os.write(data, 0, 3);
        os.flush();
        os.close();

        Reader reader = new FileReader("/Users/kwon-ohchul/Desktop/test.txt");
        int readData;
        char charData;
        while ((readData = reader.read()) != -1) {
            charData = (char) readData;
            System.out.println(charData);
        }

        // write your code here
    }
}
