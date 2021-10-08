package com.charlie.io.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * demonstrate BufferedReader
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        String pathname = "C:\\Users\\AC\\Desktop\\buffered_reader_demo.txt";
        fileCreate(pathname);
        fileBufferedReader(pathname);
    }

    //create file
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

    /**
     * BufferedReader decorate FileReader to read file
     *
     * @param pathname
     * @throws IOException readLine() method represent read a line from file once time
     *                     file reading finish until readLine() return null
     */
    public static void fileBufferedReader(String pathname) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathname));
        //read with buffered reader
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        if (bufferedReader != null) {
            //equals fileReader.close()
            bufferedReader.close();
        }
    }
}
