package com.zakl.netty.secondexample.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-30 17:33
 **/
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    int count=0;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println("Client output" + msg);
        ctx.writeAndFlush("from Client" + LocalDateTime.now());
        count++;
        if (count == 10) {
            ctx.close();
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush("来自于客户端的问候testMsg");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
