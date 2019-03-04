package com.jsj.jdk.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * 一个 NIO 的简单Server
 */
public class NioServerDemo {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(2333));
        //注册OP_ACCEPT事件，这个事件只适用于ServerSocketChannel
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //若某channel发生自己注册的事件，则方法返回
            selector.select();
            // 取得迭代器.selectedKeys()中包含了每个准备好某一I/O操作的信道的SelectionKey
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    System.out.println("acceptable");
                    SocketChannel channel = ((ServerSocketChannel) key.channel()).accept();
                    channel.configureBlocking(false);
                    //accept的channel向selector注册OP_READ事件
                    channel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()) {
                    // 获得与客户端通信的channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 得到并清空缓冲区
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    buffer.clear();

                    // 读取信息获得读取的字节数
                    long bytesRead = channel.read(buffer);

                    if (bytesRead == -1) {
                        // 没有读取到内容的情况
                        channel.close();
                    } else {
                        // 将缓冲区准备为数据传出状态
                        buffer.flip();

                        // 将字节转化为为UTF-16的字符串
                        String receivedString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();

                        // 控制台打印出来
                        System.out.println("接收到来自" + channel.socket().getRemoteSocketAddress() + "的信息:" + receivedString);

                        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                        String f = format.format(new Date());
                        // 准备发送的文本
                        String sendString = "你好,客户端. @" + f + "，已经收到你的信息:" + receivedString;
                        buffer = ByteBuffer.wrap(sendString.getBytes("UTF-8"));
                        channel.write(buffer);
                        // 设置为下一次读取或是写入做准备
                        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    }
                }
                if (key.isValid() && key.isWritable()) {
                    System.out.println("writable...");
                }
                iterator.remove();
            }
        }
    }
}
