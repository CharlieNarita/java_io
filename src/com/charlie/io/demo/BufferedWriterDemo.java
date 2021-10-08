package com.charlie.io.demo;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        String pathname = "C:\\Users\\AC\\Desktop\\buffered_writer_demo.txt";
        String src = "hello, welcome to learn Java!";

        fileBufferedWriter(pathname, src);
    }

    /**
     * BufferedWriter decorate FileWriter
     *
     * @param pathname
     * @param src
     * @throws IOException
     */
    public static void fileBufferedWriter(String pathname, String src) throws IOException {
        char[] buf = {'i', 'b', 'm'};
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathname, true));
        bufferedWriter.write(src, 0, src.length());
        //newLine() is insert system relate new line
        bufferedWriter.newLine();
        bufferedWriter.write(src);
        bufferedWriter.newLine();
        bufferedWriter.write(65);
        bufferedWriter.newLine();
        bufferedWriter.write(buf);

        //attention do not forget close resource
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
    }
}
