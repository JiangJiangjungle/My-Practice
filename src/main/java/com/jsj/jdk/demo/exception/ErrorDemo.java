package com.jsj.jdk.demo.exception;

/**
 * 测试是否能够catch Error
 */
public class ErrorDemo {

    public static void main(String[] args) {
        Object[] objects = new Object[1024];
        for (; ; ) {
            try {
                for (int i = 0; i < objects.length; i++) {
                    objects[i] = new byte[100 * 1024 * 1024];
                }
            } catch (Error error) {
                System.out.println(error.getMessage());
            }
        }
    }
}
