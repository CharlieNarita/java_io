package com.charlie.io.demo;

import java.io.*;

/**
 * buffered reader and writer can treat file with default UTF-8
 * for not default UTF-8 file such as UTF-16 use transformation
 */
public class TransformationDemo {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\AC\\Desktop\\transformation_demo.txt";
        String content = "welcome to learn coding...";

//        initFile(pathname, content);
        transformationWriter(pathname, content);
        transformationRead(pathname);
    }

    //init a file with specific path
    public static void initFile(String pathname, String content) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(pathname));
            bw.write(content);
            System.out.println("file init successful!");
        } catch (Exception e) {
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

    //InputStreamReader(InputStream, Charset);
    //it can pass a InputStream object, and designate a specific code type
    public static void transformationRead(String pathname) {
        InputStreamReader isr = null;
        String s;
        try {
            //decorate the FileInputStream as InputStreamReader
            isr = new InputStreamReader(new FileInputStream(pathname), "UTF16");
            //decorate the InputStreamReader as BufferedReader
            BufferedReader br = new BufferedReader(isr);
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println("reading is ok");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                    System.out.println("resource is closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //OutputStreamReader(OutputStream, Charset);
    //it can pass a OutputStream object, and designate a specific code type
    public static void transformationWriter(String pathname, String content) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathname), "UTF16"));
            bw.write(content);
            System.out.println("writing is ok");
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
}

