package com.zakl.netty.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-30 19:58
 **/
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    //用来保存生成的channel对象
    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        channels.forEach(ch -> {
            if (ch != ctx.channel()) {
                ch.writeAndFlush("收到来自：" + ctx.channel().remoteAddress() + " 的信息: " + msg+"\n");
            }else {
                //ctx.channel().writeAndFlush("[自己]" + msg+"\r\n"); 这种情况不会像消息返回，而是暂存在channels中，下一次有通道进来时，满足if条件才会返回
                ch.writeAndFlush("[自己]" + msg+"\r\n");

            }
        });
    }

    //连接建立
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        //向所有channel广播
        channels.writeAndFlush("[服务器]-" + channel.remoteAddress() + "加入\n");

        channels.add(channel);
    }

    //连接丢失
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channels.writeAndFlush("[服务器]-" + channel.remoteAddress() + "离线\n");

        //channels.remove(channel); 无需手工清楚失效channel
    }

    //活跃状态
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "上线了");
    }


    //不活跃状态
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();

        System.out.println(channel.remoteAddress() + "离线了");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
