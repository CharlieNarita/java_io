package com.charlie.io.demo;

import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(System.out);
        pw.print("hello welcome");

        PrintWriter pw2 = new PrintWriter(new FileWriter("C:\\Users\\AC\\Desktop\\print_writer_test.txt"));
        pw2.println("hello ibm");
        pw2.write("hello ibm");

        pw.close();
        pw2.close();
    }
}


