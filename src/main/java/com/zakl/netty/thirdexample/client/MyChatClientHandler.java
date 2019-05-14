package com.zakl.netty.thirdexample.client;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Scanner;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-30 21:02
 **/
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {
    private Scanner scanner = new Scanner(System.in);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("fromServer:   " + msg);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

    }
}
