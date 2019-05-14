package com.zakl.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: netty_lecture
 * @description: 零拷贝
 * @author: ZakL
 * @create: 2019-04-10 19:40
 **/
public class NewIodClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(true);
        socketChannel.connect(new InetSocketAddress("localhost", 8989));
        String filepath = "C:\\Users\\HP\\Desktop\\公选课转换创新实践学分模板.docx";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        FileChannel fileChannel = fileInputStream.getChannel();
        //nio零拷贝，不进入用户空间，直接在内核空间进行数据传送
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送字节数：" + transferCount);
        fileChannel.close();
        fileInputStream.close();
        socketChannel.close();
    }
}
