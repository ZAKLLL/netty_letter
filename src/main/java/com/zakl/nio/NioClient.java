package com.zakl.nio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-08 15:54
 **/
public class NioClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //对连接感兴趣
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        //连接到远程服务器
        socketChannel.connect(new InetSocketAddress(8989));


        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                try {

                    if (selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        //判断是否处于连接过程中
                        if (client.isConnectionPending()) {
                            //完成连接
                            client.finishConnect();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            byteBuffer.put((LocalDateTime.now() + client.getLocalAddress().toString() + "连接成功").getBytes());
                            byteBuffer.flip();
                            client.write(byteBuffer);
                            //使用线程池接受键盘输入
                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                while (true) {
                                    try {
                                        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                        String msg = bufferedReader.readLine();
                                        byteBuffer.clear();
                                        byteBuffer.put(msg.getBytes());
                                        byteBuffer.flip();
                                        client.write(byteBuffer);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        client.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        try {
                            int read = socketChannel1.read(byteBuffer);
                            if (read > 0) {
                                byteBuffer.flip();
                                System.out.println(new String(byteBuffer.array(), 0, read));
                            }
                        } catch (Exception e) {
                            System.out.println(socketChannel1.getRemoteAddress().toString() + "断开连接");

                            socketChannel1.close();
                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            selectionKeys.clear();
        }

    }
}
