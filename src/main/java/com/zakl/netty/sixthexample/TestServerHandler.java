package com.zakl.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-01 11:04
 **/
public class TestServerHandler extends SimpleChannelInboundHandler<MyDateInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDateInfo.MyMessage msg) throws Exception {
        if (msg.getDateType() == MyDateInfo.MyMessage.DateType.PersonType) {
            System.out.println(msg.getPerson().getAddress()+"\n"+msg.getPerson().getName()+"\n"+msg.getPerson().getAddress());
        } else if (msg.getDateType() == MyDateInfo.MyMessage.DateType.CatType) {
            System.out.println(msg.getCat().getCity() + "\n" + msg.getCat().getName());
        } else if (msg.getDateType() == MyDateInfo.MyMessage.DateType.DogType) {
            System.out.println(msg.getDog().getAge()+"\n"+msg.getDog().getName());
        }

    }
}
