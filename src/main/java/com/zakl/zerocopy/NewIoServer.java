package com.zakl.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-10 19:30
 **/
public class NewIoServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(8989));


        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);
            int readcount = 0;
            while (readcount != -1) {
                try {
                    readcount = socketChannel.read(byteBuffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                byteBuffer.rewind();
            }

        }

    }
}

