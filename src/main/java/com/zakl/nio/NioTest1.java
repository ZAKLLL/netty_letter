package com.zakl.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 12:41
 **/
public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int randomNumber = new Random().nextInt(20);
            intBuffer.put(randomNumber);
        }
        //状态反转，使buffer成为可读状态
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
