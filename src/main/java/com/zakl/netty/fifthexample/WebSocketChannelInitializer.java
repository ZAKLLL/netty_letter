package com.zakl.netty.fifthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-31 15:09
 **/
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline channelPipeline = ch.pipeline();

        //http协议编解码器
        channelPipeline.addLast(new HttpServerCodec());
        //以块的方式来写入
        channelPipeline.addLast(new ChunkedWriteHandler());
        //请求聚合
        channelPipeline.addLast(new HttpObjectAggregator(8192));
        // ws://server:port/ws websocket协议
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        channelPipeline.addLast(new TextWebSocketFrameHandler());

    }
}
