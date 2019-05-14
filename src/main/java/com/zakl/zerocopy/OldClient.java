package com.zakl.zerocopy;

import java.io.*;
import java.net.Socket;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-10 19:41
 **/
public class OldClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8989);
        String filepath = "C:\\Users\\HP\\Desktop\\公选课转换创新实践学分模板.docx";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];

        long readCount;
        long total = 0;
        while ((readCount = fileInputStream.read(bytes)) > 0) {
            total += readCount;
            dataOutputStream.write(bytes);
        }
        System.out.println("传送了："+total);
        socket.close();
        dataOutputStream.close();
        fileInputStream.close();
    }
}

