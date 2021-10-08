package com.charlie.io.demo;

import java.util.Scanner;

public class StandardInputOutput {
    public static void main(String[] args) {
        //public final static InputStream in = null; //from System class
        //System.in compile type is InputStream
        //System.in running type is BufferedInputStream
        //represent standard input
        System.out.println(System.in.getClass());   //BufferedInputStream

        //public final static PrintStream out = null;   //System.out
        //System.out compile type is PrintStream
        //System.out running type is PrintStream
        //represent standard output
        System.out.println(System.out.getClass());  //PrintStream

        //actually equals Scanner(BufferedInputStream)
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter content...");

        boolean loop = true;
        while (loop) {
            String next = scanner.next();
            if ("exit" == next.toLowerCase())
                loop = false;
            System.out.println("content = " + next);
        }
    }
}


