package com.charlie.io.demo;

import java.io.*;

/**
 * binary copy with BufferedInputStream and BufferedOutputStream
 */
public class BufferedCopyDemo2 {
    public static void main(String[] args) {
        String srcPath = "C:\\Users\\AC\\Desktop\\buffered_picture.jpg";
        String destPath = "C:\\Users\\AC\\Desktop\\buffered_copy_02.jpg";
        byte[] content = {'a', 'b', 'c', 'd', 'e', 'f'};
        initBinFile(srcPath, content);
        binCopy(srcPath, destPath);

    }

    public static void initBinFile(String srcPath, byte[] content) {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(srcPath));
            bos.write(content, 0, content.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void binCopy(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        byte[] buf = new byte[1024];
        int readLen;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcPath));
            bos = new BufferedOutputStream(new FileOutputStream(destPath));
            while ((readLen = bis.read(buf)) != -1) {
                bos.write(buf, 0, readLen);
            }

            System.out.println("file copy is ok");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
