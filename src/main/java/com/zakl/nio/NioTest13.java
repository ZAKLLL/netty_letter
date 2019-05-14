package com.zakl.nio;

import io.netty.util.CharsetUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-07 14:23
 **/
public class NioTest13 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("path"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("path"));
        BufferedReader fileReader =new BufferedReader(new FileReader("NioTestIn_13.txt")) ;//默认使用ISO-8859-1编码
        System.out.println("使用java默认编码，文件编码格式为GBK");
        while (fileReader.ready()) {
            System.out.println(fileReader.readLine());
        }
        System.out.println("采用GBK编码吗");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("NioTestIn_13.txt"),"GBK"));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }


        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OOOOOutput.txt")));
        System.out.println("PrintStream:"+PrintStream.class.getSuperclass().getName());

        while (true) {
            InputStream printStream = System.in;
            InputStreamReader inputStreamReader = new InputStreamReader(printStream);
            BufferedReader bufferedReader1 = new BufferedReader(inputStreamReader);

            String str = bufferedReader1.readLine();
            if (str.equals("bye")) {
                break;
            }
            bufferedWriter.write(str);
        }
        bufferedWriter.close();
    }
}
