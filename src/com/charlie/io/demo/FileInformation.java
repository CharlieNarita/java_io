package com.charlie.io.demo;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * how to get file information
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    //get file information
    @Test
    public void info() {
        File file = new File("C:\\Users\\AC\\Desktop\\new_file_test01.txt");

        //get name
        System.out.println("file name = " + file.getName());

        //get absolute path
        System.out.println("absolute path = " + file.getAbsolutePath());

        //get parent directory
        System.out.println("parent = " + file.getParent());

        //get size of file(how many byte of content in file)
        System.out.println("size of file = " + file.length());

        //detect the file exits or not
        System.out.println("file exits or not? " + file.exists());

        //is file or not
        System.out.println("is a file or not? " + file.isFile());

        //is directory or not
        System.out.println("is a directory or not? " + file.isDirectory());
    }
}


