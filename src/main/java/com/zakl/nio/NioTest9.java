package com.zakl.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-07 08:25
 **/
public class NioTest9 {
    public static void main(String[] args) throws  Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest9.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        //位于堆外内存 修改该buffer对源文件内存可见。会修改源文件内容
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'T');
        mappedByteBuffer.put(3, (byte) 'W');
        mappedByteBuffer.flip();
        randomAccessFile.close();
    }
}
