package com.charlie.io.demo.decorator_pattern_demo;

class BufferedReaderDemo extends ReaderDemo {
    private ReaderDemo rd;
    private int num;

    public BufferedReaderDemo(ReaderDemo rd) {
        this.rd = rd;
    }

    @Override
    public void read() {
        for (int i = 0; i < num; i++) {
            rd.read();
        }
    }

    public void initNum(int num) {
        this.num = num;
    }
}
