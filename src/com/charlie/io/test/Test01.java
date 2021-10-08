package com.charlie.io.test;

import java.io.*;

public class Test01 {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\AC\\Desktop\\my_temp";
        String filePath = directoryPath + "\\hello.txt";
        String content = "hello world";
        directoryCreate(directoryPath);
        fileCreate(filePath);
        fileWrite(filePath, content);
    }

    public static void directoryCreate(String directoryPath) {
        File file = new File(directoryPath);
        if(!file.exists()) {
            if(file.mkdirs()) {
                System.out.println(directoryPath + " has been created successful!");
            } else {
                System.out.println(directoryPath + " created fault");
            }
        } else {
            System.out.println(directoryPath + " exists");
        }
    }

    public static void fileCreate(String filePath) {
        File file = new File(filePath);
        if(!file.exists()) {
            try {
                if(file.createNewFile()) {
                    System.out.println(filePath + " has been created successful");
                } else {
                    System.out.println(filePath + " created fault");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(filePath + " exists");
        }
    }

    public static void fileWrite(String filePath, String content) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(content);
            bw.newLine();
            System.out.println("file writing is ok");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
