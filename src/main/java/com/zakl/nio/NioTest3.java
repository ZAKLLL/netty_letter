package com.zakl.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 14:52
 **/
public class NioTest3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/zakl/nio/NioTest3.txt");
        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        byte[] messages = "message text".getBytes();
        byte[] messages2 = "new message text".getBytes();

        for (byte message : messages) {
            byteBuffer.put(message);
        }
        //将buffer设为可读状态
        byteBuffer.flip();

        //将byteBuffer中的消息写入到channel中
        channel.write(byteBuffer);


        byteBuffer.rewind();//重新使得position的位置置于0;数据不变
        channel.write(byteBuffer);

        channel.close();
        fileOutputStream.close();


        byteBuffer.clear(); //相当于重置了该buffer
        for (int i = 0; i < messages2.length; i++) {
            byteBuffer.put(messages2[i]);
        }

        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char)byteBuffer.get());
        }

    }
}
