package com.jsj.jdk.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * 反射机制中Class对象相关的方法
 */
public class ClassDemo {
    private static String prs = "this is a private static String value";
    public static String pus = "this is a public static String value";
    private String pr = "this is a private String value";
    public String pu = "this is a public String value";

    public static void methodA(String param1) {
    }

    private static void methodB(String param2) {
    }

    public void methodC(String param3) {
    }

    private void methodD(String param4) {
    }

    public static void main(String[] args) throws Exception {
        Class clazz = ClassDemo.class;
        testField(clazz);
    }

    public static void testField(Class clazz) throws Exception {
        //获取Class对象中所有字段
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("-----------------print declared fields-----------------");
        System.out.println(Arrays.toString(fields));
        System.out.println("-----------------print fields-----------------");
        fields = clazz.getFields();
        System.out.println(Arrays.toString(fields));
        Field field = fields[0];
        System.out.println("-----------------打印第一个字段的变量名以及变量值-----------------");
        ClassDemo instance = new ClassDemo();
        field.setAccessible(true);
        Type type = field.getGenericType();
        System.out.println("字段类型：" + type.getTypeName() + " 字段变量名：" + field.getName() + " 字段变量值: " + field.get(instance));
    }

    public static void testMethod(Class clazz) {
        //获取Class对象中所有方法
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("-----------------print declared methods-----------------");
        System.out.println(Arrays.toString(methods));
        methods = clazz.getMethods();
        System.out.println("-----------------print methods-----------------");
        System.out.println(Arrays.toString(methods));
        Method method = methods[0];
        System.out.println("-----------------打印第一个方法的方法名以及参数类型（但是无法获取参数名）-----------------");
        System.out.print(method.getName() + " ");
        Class[] classes = method.getParameterTypes();
        System.out.println(Arrays.toString(classes));
    }
}
