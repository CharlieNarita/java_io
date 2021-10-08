package com.charlie.io.test;

import java.io.*;

public class Test02 {
    public static void main(String[] args) {
        String srcPath = "src\\com\\charlie\\io\\test\\Test01.java";
        String filePath = "C:\\Users\\AC\\Desktop\\my_file.txt";

        fileShow(srcPath, filePath);
    }

    public static void fileShow(String srcPath, String filePath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        String line;
        String numLine;
        int lineCount = 0;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(srcPath), "UTF8");
            br = new BufferedReader(isr);
            bw = new BufferedWriter(new FileWriter(filePath));
            pw = new PrintWriter(System.out);
            while ((line = br.readLine()) != null) {
                numLine = (++lineCount) + " " + line;
                bw.write(numLine);
                bw.newLine();
                pw.println(numLine);
            }
            System.out.println("reading is ok");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
