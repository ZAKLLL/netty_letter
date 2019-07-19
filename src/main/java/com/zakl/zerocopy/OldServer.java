package com.zakl.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-10 19:20
 **/
public class OldServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8989);
        long count=0;

        while (true) {
            Socket accept = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());
            try {
                byte[] bytes = new byte[4096];
                while (true) {
                    int read = dataInputStream.read(bytes, 0, bytes.length);
                    if (read <= 0) {
                        System.out.println(count);
                        break;
                    }
                    count += read;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
