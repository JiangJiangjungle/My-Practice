package com.jsj.jdk.demo;

import java.nio.ByteBuffer;

/**
 * 使用堆外内存
 */
public class BufferDemo {
    public static void main(String[] args) throws Throwable {
        ByteBuffer buffer = ByteBuffer.allocateDirect(64);
        while (true) {
            buffer.put((byte) 'a');
            System.out.println(buffer);
            Thread.sleep(5000);
        }
    }
}
