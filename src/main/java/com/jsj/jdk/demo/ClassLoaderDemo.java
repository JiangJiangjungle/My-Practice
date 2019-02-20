package com.jsj.jdk.demo;

import java.io.*;

/**
 * 自定义类加载器
 */
public class ClassLoaderDemo extends ClassLoader {
    static String classPath;

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoaderDemo();
//        for (ClassLoader parent = classLoader.getParent(); parent != null; parent = parent.getParent()) {
//            System.out.println(parent.toString());
//        }
        Class clazz = classLoader.loadClass("com.jsj.company.ScannerDemo");
        System.out.println(clazz);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        classPath = ClassLoaderDemo.class.getResource("/").getPath();
        byte[] data = getData(name, classPath);
        if (data == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, data, 0, data.length);
        }
    }

    private byte[] getData(String name, String classPath) {
        String path = classPath + name.replace('.', File.separatorChar) + ".class";
        try (InputStream is = new BufferedInputStream(new FileInputStream(path));
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[1024];
            for (int len = bytes.length; (len = is.read(bytes, 0, len)) != -1; ) {
                os.write(bytes, 0, len);
            }
            return os.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
