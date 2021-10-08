package com.charlie.io.demo.decorator_pattern_demo;

public class DecoratorDemo {
    public static void main(String[] args) {
        BufferedReaderDemo bufferedReaderDemo = new BufferedReaderDemo(new FileReaderDemo());
        BufferedReaderDemo bufferedReaderDemo1 = new BufferedReaderDemo(new StringReaderDemo());

        bufferedReaderDemo.initNum(10);
        bufferedReaderDemo1.initNum(5);

        bufferedReaderDemo.read();
        bufferedReaderDemo1.read();

    }
}
