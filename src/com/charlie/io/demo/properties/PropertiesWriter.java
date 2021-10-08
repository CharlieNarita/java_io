package com.charlie.io.demo.properties;

import java.io.*;
import java.util.Properties;

/**
 * Properties has super class Hashtable
 * so Properties based on  hashtable and double linked list data structure
 * that means operations like add or delete will under key-value structure rule
 */
public class PropertiesWriter {
    public static void main(String[] args) throws IOException {
        //modify or create config file by Properties instance
        Properties properties = new Properties();

        //create
        /*
            1.the Properties extends Hashtable
            2.so that if there is the key exists, then will modify value match this key
            3.if the key did not exist, then will create new key-value
         */
        properties.setProperty("charset", "utf8");
        properties.setProperty("account_id", "666");
        properties.setProperty("player", "AK");

        //save the key-value into the file
        properties.store(new FileOutputStream("src\\mysql.properties"), "update1.0");
        System.out.println("config saved successful");
    }
}
