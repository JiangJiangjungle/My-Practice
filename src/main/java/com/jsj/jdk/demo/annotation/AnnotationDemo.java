package com.jsj.jdk.demo.annotation;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解测试类
 */
public class AnnotationDemo {

    public static void main(String[] args) throws Exception {
        String packageLocation = Class.class.getClass().getResource("/").getPath();
        //扫描类路径下所有类
        List<Class> classList = getAllClass(packageLocation, "com.jsj.jdk.demo.annotation");
        for (Class clz : classList) {
            System.out.println(clz.getName() + "-------------------");
            //获取一个Class（包括接口）所带的所有注解
            Annotation[] annotations = clz.getAnnotations();
            for (Annotation a : annotations) {
                System.out.println(a);
            }
        }
    }

    public static List<Class> getAllClass(String classLocation, String packageName) throws Exception {
        File packeageDir = new File(classLocation + packageName.replaceAll("[.]", "\\\\"));
        String[] packageNames = packeageDir.list();
        List<Class> classes = null;
        Class clz;
        if (packageNames != null) {
            for (int i = 0; i < packageNames.length; i++) {
                packageNames[i] = packageName + "." + packageNames[i].substring(0, packageNames[i].indexOf(".class"));
                if ((clz = Class.forName(packageNames[i])) != null) {
                    if (classes == null) {
                        classes = new ArrayList<>();
                    }
                    classes.add(clz);
                }
            }
        }
        return classes;
    }
}
