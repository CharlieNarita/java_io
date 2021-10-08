package com.charlie.io.demo;

import java.io.*;

/**
 * ObjectOutputStream serializable
 */
public class ObjectStreamDemo {
    public static void main(String[] args) {
        //after serializable, the file format is not txt
        String pathname = "C:\\Users\\AC\\Desktop\\object_output.dat";
        Object cat = new Cat("tom", "yellow");

        objectSerialization(pathname, cat);
        objectDeserialization(pathname);
    }

    public static void objectSerialization(String pathname, Object obj) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(pathname));
            //serialize the data to destination
            oos.writeObject(obj);
            oos.writeInt(100); //int -> Integer(implements Serializable)
            oos.writeBoolean(true); //boolean -> Boolean(implements Serializable)
            oos.writeChar('a'); //char -> Character (implements Serializable)
            oos.writeDouble(9.5);   //double -> Double (implements Serializable)
            oos.writeUTF("C/C++");  //String
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                    System.out.println("data saved(serializable way)");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * deserializable has read method
     * read sequence must match write sequence one by one
     * the order and sequence is the essential why called serialization
     *
     * @param pathname
     */
    public static void objectDeserialization(String pathname) {
        ObjectInputStream ois = null;
        Object obj;
        try {
            ois = new ObjectInputStream(new FileInputStream(pathname));
            //notice! read sequence must match write sequence
            obj = ois.readObject();
            System.out.println(obj + " obj running type: " + obj.getClass());    //dog obj

            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readChar());
            System.out.println(ois.readDouble());
            System.out.println(ois.readUTF());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * implements Serialization
 */
class Cat implements Serializable {
    private String name;
    private String color;

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return name + " " + color;
    }
}
