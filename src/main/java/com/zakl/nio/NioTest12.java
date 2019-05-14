package com.zakl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-07 10:10
 **/
public class NioTest12 {
    public static void main(String[] args) throws IOException {
        int[] ports = new int[5];
        ports[0] = 5000;
        ports[1] = 5001;
        ports[2] = 5002;
        ports[3] = 5003;
        ports[4] = 5004;
        Selector selector = Selector.open();

        //对Channel的四个event都感兴趣
        int interestSet = SelectionKey.OP_ACCEPT | SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE;
        for (int port : ports) {
            //ServerSocketChannel 是一个可以监听新进来的TCP连接的通道,包含一个SocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //调整为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //将端口绑定到Channel上
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口：" + port);
        }
        while (true) {
            
            int number = selector.select();
            System.out.println("number:"+number);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //当这个channel是连接就绪状态
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel =(ServerSocketChannel) selectionKey.channel();
                    //获取ServerSocketChannel包含的SocketChannel用来与用户交互数据
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("获得客户端"+socketChannel+serverSocketChannel.getLocalAddress().toString());
                    iterator.remove();
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int byteRead=0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                        int read = socketChannel.read(byteBuffer);
                        if (read <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteRead += read;
                    }
                    System.out.println("byteRead:"+byteRead);
                    iterator.remove();
                }
            }
        }
    }
}
