package com.zakl.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-07 08:33
 **/
public class NioTest10 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("NioTest10", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        //设定一个共享锁
        FileLock fileLock = fileChannel.lock(3, 6, true);
        System.out.println("valid:" +fileLock.isValid());
        System.out.println("lock type:" +fileLock.isShared());
        fileLock.release();
        randomAccessFile.close();

    }
}
