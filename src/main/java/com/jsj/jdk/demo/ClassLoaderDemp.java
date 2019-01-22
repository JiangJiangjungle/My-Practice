package com.jsj.jdk.demo;

public class ClassLoaderDemp extends ClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoaderDemp();
        for (ClassLoader parent = classLoader.getParent(); parent != null; parent = parent.getParent()) {
            System.out.println(parent.toString());
        }
    }
}
