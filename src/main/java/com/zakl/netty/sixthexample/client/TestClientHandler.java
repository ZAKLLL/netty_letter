package com.zakl.netty.sixthexample.client;

import com.zakl.netty.sixthexample.MyDateInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.Random;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-01 11:12
 **/
public class TestClientHandler extends SimpleChannelInboundHandler<MyDateInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDateInfo.MyMessage msg) throws Exception {


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int i = new Random().nextInt(3);

        MyDateInfo.MyMessage myMessage=null;

        switch (i) {
            case 0:
                myMessage = MyDateInfo.MyMessage.newBuilder()
                        .setDateType(MyDateInfo.MyMessage.DateType.PersonType)
                        .setPerson(MyDateInfo.Person.newBuilder().setName("张三").setAge(19).setAddress("天安门").build())
                        .build();
                break;
            case 1:
                myMessage = MyDateInfo.MyMessage.newBuilder()
                        .setDateType(MyDateInfo.MyMessage.DateType.DogType)
                        .setDog(MyDateInfo.Dog.newBuilder().setName("二狗").setAge(5).build())
                        .build();
                break;
            case 2:
                myMessage = MyDateInfo.MyMessage.newBuilder()
                        .setDateType(MyDateInfo.MyMessage.DateType.CatType)
                        .setCat(MyDateInfo.Cat.newBuilder().setName("三猫").setCity("珠海").build())
                        .build();
                break;
        }

        ctx.channel().writeAndFlush(myMessage);


    }
}
