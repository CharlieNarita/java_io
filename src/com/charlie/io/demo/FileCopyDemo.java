package com.charlie.io.demo;

import java.io.*;

public class FileCopyDemo {
    public static void main(String[] args) {
        String srcPath = "C:\\Users\\AC\\Desktop\\FileCopy_Test.txt";
        String destPath = "C:\\Users\\AC\\Desktop\\FileCopy_Test_Copy.txt";
        fileCreate(srcPath);
        fileCopy(srcPath, destPath);
    }

    //create new file
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

    //copy file to destination directory
    public static void fileCopy(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buf = new byte[1024];
        int readLen;

        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //public void write(byte b[], int off, int len)
                fileOutputStream.write(buf, 0, readLen);
            }
            System.out.println("copy is ok!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
