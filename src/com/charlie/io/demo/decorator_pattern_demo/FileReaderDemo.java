package com.charlie.io.demo.decorator_pattern_demo;

/**
 * FileReaderDemo is Node Stream
 */
class FileReaderDemo extends ReaderDemo {
    @Override
    public void read() {
        System.out.println("read file");
    }
}
