package com.zakl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-08 10:07
 **/
public class NioServer {
    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        //绑定监听8899端口
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8989));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(
                        selectionKey -> {
                            final SocketChannel socketChannel;
                            try {
                                if (selectionKey.isAcceptable()) {
                                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                                    socketChannel = server.accept();
                                    System.out.println("客户端：" + socketChannel.getRemoteAddress() + "已经通过端口：" + socketChannel.getLocalAddress() + "连接");
                                    socketChannel.configureBlocking(false);
                                    socketChannel.register(selector, SelectionKey.OP_READ);
                                    clientMap.put("[" + UUID.randomUUID().toString() + "]", socketChannel);
                                    selectionKeys.remove(selectionKey);
                                } else if (selectionKey.isReadable()) {
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                                    socketChannel = (SocketChannel) selectionKey.channel();
                                    try {
                                        int read = socketChannel.read(byteBuffer);
                                        if (read > 0) {
                                            byteBuffer.flip();
                                            Charset charset = Charset.forName("utf-8");
                                            String receiveMsg = String.valueOf(charset.decode(byteBuffer).array());
                                            System.out.println(socketChannel + ":" + receiveMsg);

                                            for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                                SocketChannel returnMsg = entry.getValue();
                                                ByteBuffer msgByffer = ByteBuffer.allocate(1024);
                                                msgByffer.put(("senderkey:" + entry.getKey() + receiveMsg).getBytes());
                                                msgByffer.flip();
                                                returnMsg.write(msgByffer);
                                            }
                                        }
                                    } catch (Exception e) {
                                        System.out.println(socketChannel.getRemoteAddress().toString() + "断开连接");
                                        socketChannel.close();
                                        String senderkey = null;
                                        for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                            if (entry.getValue() == socketChannel) {
                                                senderkey = entry.getKey();
                                                break;
                                            }
                                        }
                                        clientMap.remove(senderkey, socketChannel);
                                    }
                                    selectionKeys.remove(selectionKey);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
