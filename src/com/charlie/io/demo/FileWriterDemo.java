package com.charlie.io.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileWriterDemo {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\AC\\Desktop\\file_writer_demo.txt";
//        fileWrite(pathname);
        fileWrite2(pathname);
    }

    //with char[]
    public static void fileWrite(String pathname) {
        FileWriter fileWriter = null;
        String info = "hello, world!";
        char[] buf = info.toCharArray();
        try {
            fileWriter = new FileWriter(pathname);
            fileWriter.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //with int type data
    public static void fileWrite2(String pathname) {
        FileWriter fileWriter = null;
        String info = "hello, Java!";
        char[] chars = info.toCharArray();
        int[] data = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            data[i] = (int) chars[i];
        }

        try {
            fileWriter = new FileWriter(pathname);
            for (int i = 0; i < data.length; i++) {
                fileWriter.write(data[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    //equals fileWriter.flush() + close()
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
