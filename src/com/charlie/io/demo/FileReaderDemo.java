package com.charlie.io.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * demonstrate FileReader
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\AC\\Desktop\\file_reader_test.txt";
        fileCreate(pathname);
//        fileRead(pathname);
        fileRead2(pathname);
    }

    //create test file
    public static void fileCreate(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            System.out.println(pathname + " exists");
        } else {
            try {
                if (file.createNewFile()) {
                    System.out.println(pathname + " is created successful!");
                } else {
                    System.out.println(pathname + " is created fault!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //test FileReader with char[]
    public static void fileRead(String pathname) {
        FileReader fileReader = null;
        char[] buf = new char[1024];
        int charLen;
        try {
            fileReader = new FileReader(pathname);
            while ((charLen = fileReader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, charLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //test FileReader with char
    public static void fileRead2(String pathname) {
        FileReader fileReader = null;
        //define a int type data
        int data;
        try {
            fileReader = new FileReader(pathname);
            //int type data receive read() method return in value
            while ((data = fileReader.read()) != -1) {
                //force cast int type data to char type according ASCII table
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
