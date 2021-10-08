package com.charlie.io.demo.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesRead {
    public static void main(String[] args) throws IOException {
        //use Properties instance read mysql.properties file

        //1.create properties object
        Properties properties = new Properties();
        //2.load config file
        properties.load(new FileReader("src\\mysql.properties"));
        //3.show key-value to console
        properties.list(System.out);

        System.out.println("----------------------");

        //get value by key
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        String ip = properties.getProperty("ip");
        System.out.println("user is: " + user);
        System.out.println("pwd is: " + pwd);
        System.out.println("ip is: " + ip);
    }
}
