package com.charlie.io.demo;

import java.io.*;

/**
 * byte print stream
 * PrintStream extends FileOutputStream
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException{
        PrintStream printStream = System.out;
        //PrintStream default output destination is monitor
        //equals System.out.print()
        /*
            public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s);   //actually invoke write() method
            }
         */
        printStream.print("hello printer");
        //because write() is truly output method
        //so use write() directly
        printStream.write("hello printer".getBytes());

        //change destination of output
        //PrintStream is FileOutputStream so that can pass file path in it
        /*
            public static void setOut(PrintStream out) {
                checkIO();
                setOut0(out); //native
            }
         */
        System.setOut(new PrintStream("C:\\Users\\AC\\Desktop\\print_test.txt"));
        System.out.println("hello developer");

        printStream.close();
    }
}
