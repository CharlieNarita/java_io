package com.charlie.io.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * write data into file through FileOutputStream object
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\AC\\Desktop\\FileOutputStream_Test.txt";
        createFile(pathname);
        writeFile01(pathname);
    }

    //create file
    public static void createFile(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            System.out.println(pathname + " exists");
        } else {
            try {
                file.createNewFile();
                System.out.println(pathname + " is created successful!");
            } catch (IOException e) {
                System.out.println(pathname + " is created fault!");
            }
        }
    }

    /**
     * public FileOutputStream(String name) this way will cover the old content in file!
     * public FileOutputStream(File file) this way will cover the old content in file!
     * public FileOutputStream(String name, boolean append) will append new data after old content in file
     */
    public static void writeFile01(String pathname) {
        FileOutputStream fileOutputStream = null;

        try {
            //establish new output stream object
            fileOutputStream = new FileOutputStream(pathname, true);
            //write data
            fileOutputStream.write('h');
            fileOutputStream.write('e');
            fileOutputStream.write('l');
            fileOutputStream.write('l');
            fileOutputStream.write('o');

            String str = ", world";
            fileOutputStream.write(str.getBytes());

            String str2 = " hello, java and c/++";
            fileOutputStream.write(str2.getBytes(), 0, str2.length());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


