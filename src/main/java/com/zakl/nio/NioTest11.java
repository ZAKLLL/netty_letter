package com.zakl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @program: netty_lecture
 * @description:关于Buffer的Scattering与Gathering
 * @author: ZakL  gater/gather
 * @create: 2019-04-07 08:39
 **/
public class NioTest11 {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        //服务器监听8899端口
        serverSocketChannel.socket().bind(address);
        int messageLength = 2 + 3 + 4;
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverSocketChannel.accept();

        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long r = socketChannel.read(byteBuffers);
                bytesRead += r;
                System.out.println("byteRead:" + bytesRead);
                //stream将每一个buffer对象转化成String对象
                Arrays.asList(byteBuffers).stream().map(buffer->"position:"+buffer.position()+"limit:"+buffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(byteBuffer -> {
                byteBuffer.flip();
            });
            long byteWritten =0;
            while (byteWritten < messageLength) {
                long r = socketChannel.write(byteBuffers);
                byteWritten += r;
            }
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());
            System.out.println("bytesRead:" + bytesRead + ",bytesWritten:" + byteWritten + ",messageLength:"+messageLength);
        }

    }
}
