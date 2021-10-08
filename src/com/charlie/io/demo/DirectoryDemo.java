package com.charlie.io.demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class DirectoryDemo {
    public static void main(String[] args) {

    }

    //detect target file exists or not, if exist then delete it
    @Test
    public void m1() {
        File file = new File("C:\\Users\\AC\\Desktop\\new_file_test01.txt");
        boolean b = file.delete();
        System.out.println("the file exists or not? " + b);
        if (b)
            System.out.println("the file deleted successful!");
    }

    //if file exist, delete it, otherwise note not exist
    //in Java, directory is a kind of file
    @Test
    public void m2() {
        String filePath = "C:\\Users\\AC\\Desktop\\new_file_test01.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + " has been deleted successful!");
            } else {
                System.out.println(filePath + " has been deleted fault!");
            }
        } else {
            System.out.println(filePath + "file is not exist!");
        }
    }

    //if file is not exist, create new one
    @Test
    public void m3() {
        String filePath = "C:\\Users\\AC\\Desktop\\new_file_test01.txt";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(filePath + " is created successful!");
            } catch (IOException e) {
                System.out.println(filePath + " is created fault!");
            }
        } else {
            System.out.println(filePath + " exists!");
        }
    }

    //make directory
    //multi-level directory use mkdirs() instead of mkdir(), they are different
    @Test
    public void m4() {
        String directoryPath = "C:\\Users\\AC\\Desktop\\directory_test\\demo";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + " exists!");
        } else {
            if (file.mkdirs()) { //make multi-level dirs
                System.out.println(directoryPath + " is made successful!");
            } else {
                System.out.println(directoryPath + " is made fault!");
            }
        }
    }
}
