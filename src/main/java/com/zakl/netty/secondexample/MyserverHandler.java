package com.zakl.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-30 17:13
 **/
//-----------------------------------------------------------此处的泛型表示处理的数据类型
public class MyserverHandler extends SimpleChannelInboundHandler<String> {
    int count =0;

    @Override                  //调用的上下文                客户端的请求对象
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        ctx.channel().writeAndFlush("from server" + UUID.randomUUID());
        count++;
        if (count == 10) {
            ctx.close();
        }
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //接收到异常时关闭连接
        ctx.close();
    }
}
