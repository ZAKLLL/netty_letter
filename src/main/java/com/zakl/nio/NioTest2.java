package com.zakl.nio;

import sun.java2d.pipe.ShapeSpanIterator;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 14:28
 **/
public class NioTest2 {
    public static void main(String[] args) throws IOException {
        //io读取数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/com/zakl/nio/NioTest2.txt")));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        System.out.println("----------");
        //nio读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        FileChannel fileChannel = new FileInputStream("src/main/java/com/zakl/nio/NioTest2.txt").getChannel();
        //将Channel中的数据读取到byteBuffer中
        fileChannel.read(byteBuffer);
        //改变bytebuffer状态，由可写变成可读
        byteBuffer.flip();
        System.out.println(new String (byteBuffer.array()));

        System.out.println("------------使用Filereader");
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/main/java/com/zakl/nio/NioTest2.txt"));
        System.out.println(bufferedReader1.readLine());
    }
}
