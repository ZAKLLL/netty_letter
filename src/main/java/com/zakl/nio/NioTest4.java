package com.zakl.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 17:28
 **/
public class NioTest4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffers = ByteBuffer.allocate(10);

        while (true) {

            //每一次循环将buffer初始化，可以重新从position=0的位置写入数据
            byteBuffers.clear();

            //从channel中读取数据
            int read = inputChannel.read(byteBuffers);
            if (read == -1) {
                break;
            }

            byteBuffers.flip();

            //像Channel中写入数据
            outputChannel.write(byteBuffers);
        }
        inputChannel.close();
        outputChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
