package com.jsj.jdk.demo;

import com.alibaba.fastjson.JSON;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.*;
import java.util.Arrays;

/**
 * 序列化测试
 */
public class SerializableDemo implements Serializable {

    static class F extends SerializableDemo {
        int f = 2;
    }

    static class B extends F {
        int b = 3;
    }

    private static String string1 = "can not serialize";

    private int num = 666;
    private String string2 = "这是中文";
    private byte[] bytes = new byte[]{0, 1, 2, 6, 6, 6};

    public SerializableDemo() {
    }

    @Override
    public String toString() {
        return "SerializableDemo{" +
                "num=" + num +
                ", string2='" + string2 + '\'' +
                ", bytes=" + Arrays.toString(bytes) +
                '}';
    }

    public static void main(String[] args) throws Exception {
        //序列化后写入文件
        SerializableDemo serializableDemo = new SerializableDemo();
        FileOutputStream fos = new FileOutputStream("D:\\logs\\temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        System.out.println("----------------------进行JDK序列化----------------------");
        oos.writeObject(serializableDemo);
        //读取序列化后的文件
        FileInputStream fis = new FileInputStream("D:\\logs\\temp.out");
        byte[] bytes = new byte[256];
        int size = 0;
        for (int readByte = bytes.length; (readByte = fis.read(bytes, 0, readByte)) != -1; ) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(bytes, 0, readByte)));
            size += readByte;
        }
        System.out.println("本次序列化大小为：" + size + " 字节。");
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\logs\\temp.out"));
        SerializableDemo object = (SerializableDemo) ois.readObject();
        System.out.println("----------------------通过JDK反序列化恢复----------------------");
        System.out.println(object.toString());
        System.out.println();

        //利用JSON进行序列化
        System.out.println("----------------------进行JSON序列化----------------------");
        bytes = JSON.toJSONBytes(serializableDemo);
        String trans = new String(bytes);
        System.out.println(trans);
        System.out.println("本次序列化大小为：" + bytes.length + " 字节。" + trans.toCharArray().length);
        System.out.println("----------------------通过JSON反序列化恢复----------------------");
        object = JSON.parseObject(trans, SerializableDemo.class);
        System.out.println(object.toString());

        //利用Protostuff进行序列化
        LinkedBuffer buffer = LinkedBuffer.allocate(256);
        Schema<SerializableDemo> schema = RuntimeSchema.createFrom(SerializableDemo.class);
        bytes = ProtostuffIOUtil.toByteArray(serializableDemo, schema, buffer);
        buffer.clear();
        System.out.println("----------------------进行Protostuff序列化----------------------");
        System.out.println(Arrays.toString(bytes));
        System.out.println("本次序列化大小为：" + bytes.length + " 字节。");
        object = SerializableDemo.class.newInstance();
        ProtostuffIOUtil.mergeFrom(bytes, object, schema);
        System.out.println("----------------------通过Protostuff反序列化恢复----------------------");
        System.out.println(object.toString());

        B b1 = new B();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static String getString1() {
        return string1;
    }

    public static void setString1(String string1) {
        SerializableDemo.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
