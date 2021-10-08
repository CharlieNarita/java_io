package com.charlie.io.demo;

import java.io.*;

public class BufferedCopyDemo {
    public static void main(String[] args) {
        String fileContent = "welcome to computer world, hello developer, enjoy Java";
        String srcPath = "C:\\Users\\AC\\Desktop\\buffered_copy_src.txt";
        String destPath = "C:\\Users\\AC\\Desktop\\buffered_copy_dest.txt";

        initSrcFile(srcPath, fileContent);
        bufferCopy(srcPath, destPath);
    }

    //init the src file
    public static void initSrcFile(String srcPath, String fileContent) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(srcPath, true));
            bw.write(fileContent, 0, fileContent.length());
            bw.newLine();
            bw.write(fileContent);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //copy file by buffer
    public static void bufferCopy(String srcPath, String destPath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(srcPath));
            bw = new BufferedWriter(new FileWriter(destPath));
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("copy is ok");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
