package com.jsj.jdk.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/**
 * 使用堆外内存
 */
public class BufferDemo {
    public static void main(String[] args) throws Exception {
//        ByteBuffer buffer = ByteBuffer.allocateDirect(64);
//        while (true) {
//            buffer.put((byte) 'a');
//            System.out.println(buffer);
//            Thread.sleep(5000);
//        }
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\logs\\test.sql"));
        for (int i = 1; i <= 5000; i++) {
            outputStream.write(new String("INSERT INTO `tb_user`(`user_name`,`phone`) VALUES ('tom_"+i+"','13855558888');\r\n").getBytes());
        }
        outputStream.flush();
        outputStream.close();
    }
}
