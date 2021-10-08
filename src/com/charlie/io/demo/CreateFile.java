package com.charlie.io.demo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * demonstration of file creation
 */
public class CreateFile {
    public static void main(String[] args) {

    }

    //1. new File(String pathname)
    @Test
    public void createFile01() {
        String filePath = "C:\\Users\\AC\\Desktop\\new_file_test01.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the file created successful!\nthe new file is " + filePath);
    }

    //2. new File(File parent, String child)
    @Test
    public void createFile02() {
        File parentFile = new File("C:\\Users\\AC\\Desktop\\"); //get parent file
        String fileName = "new_file_test02.txt";    //get new file name
        File newFile = new File(parentFile, fileName);  //pass the parent and file name
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the file created successful!\nthe new file is " +
                parentFile.getName() + " " + fileName);
    }

    //3. new File(String parent, String child)
    @Test
    public void createFile03() {
        String parent = "C:\\Users\\AC\\Desktop\\";
        String child = "new_file_test03.txt";
        File newFile = new File(parent, child);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("the file created successful!\nthe new file is " +
                parent + " " + child);
    }
}
