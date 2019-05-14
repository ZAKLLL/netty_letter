package com.zakl.netty.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-30 11:09
 **/
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //类似于一个拦截器链
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("httpServerCodec", new HttpServerCodec()); //对于web请求进行编解码作用
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
        //ss
    }
}
