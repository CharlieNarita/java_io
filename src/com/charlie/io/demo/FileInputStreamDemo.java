package com.charlie.io.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * demonstrate FileInputStream usage
 */
public class FileInputStreamDemo {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\AC\\Desktop\\FileInputStream_Test.txt";
//        createFile(pathname);
//        readFile01(pathname);
        readFile02(pathname);
    }

    public static void createFile(String pathname) {
        File file = new File(pathname);
        if (file.exists()) {
            System.out.println(pathname + " exists!");
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
     * read data as int to char one by one through FileInputStream object
     *
     * @param pathname method read() is low efficiency so commonly use read(byte[] b) instead of read()
     */
    public static void readFile01(String pathname) {
        int readData = 0;
        //create FileInputStream object, for reading file content
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(pathname);
            //read a byte data from input stream, method return if nothing can read
            //return -1 when file reading finish
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close stream, release resource
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //read(byte[] b) method
    public static void readFile02(String pathname) {
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[1024];
        int readLen = 0;

        try {
            fileInputStream = new FileInputStream(pathname);
            //read(byte[] b) return actual read byte count numbers once time
            //these numbers represent ASCII code value
            //return -1 when finish reading
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //use String(byte[] b)
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
