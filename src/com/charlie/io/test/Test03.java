package com.charlie.io.test;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Test03 {
    public static void main(String[] args) {
        //create dog by reading info from dog.properties
        String propertiesPath = "src\\com\\charlie\\io\\test\\dog.properties";
        Properties p = new Properties();
        try {
            p.load(new FileReader(propertiesPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //get properties by getProperty() method
        String name = p.getProperty("name");
        int age = Integer.parseInt(p.getProperty("age"));
        String color = p.getProperty("color");
        //init dog instance
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        //write info into dog.properties from a Dog instance
        Dog dog1 = new Dog("haha", 1024, "green");
        p.setProperty("name", dog1.getName());
        p.setProperty("age", String.valueOf(dog1.getAge()));
        p.setProperty("color", dog1.getColor());
        p.list(System.out);

        //serialize the dog instance to a dog.dat file
        String serFilePath = "src\\com\\charlie\\io\\test\\dog.dat";
        ObjectOutputStream oos = null;
        try {
             oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
             oos.writeObject(dog1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos!=null) {
                try {
                    oos.close();
                    System.out.println("Dog obj serialization is ok");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void deserializableDog() {
        String serFilePath = "src\\com\\charlie\\io\\test\\dog.dat";
        ObjectInputStream ois = null;
        Dog d = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(serFilePath));
            Object o = ois.readObject();
            if(o instanceof Dog) {
               d = (Dog)o;
            } else {
                System.out.println("object is not Dog");
            }
            System.out.println(d);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
