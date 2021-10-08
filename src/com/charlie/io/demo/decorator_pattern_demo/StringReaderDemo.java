package com.charlie.io.demo.decorator_pattern_demo;

/**
 * StringReaderDemo is Node Stream
 */
class StringReaderDemo extends ReaderDemo {
    @Override
    public void read() {
        System.out.println("read string");
    }
}
