package com.zakl.netty.fourthexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-31 10:01
 **/
                                    //
public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //空闲状态转换
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            String evenType = null;

            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    evenType = "读空闲";
                    break;
                case WRITER_IDLE:
                    evenType = "写空闲";
                    break;
                case ALL_IDLE:
                    evenType = "读写空闲";
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + "超时事件：" + evenType);
            ctx.channel().close();

        }
    }
}
