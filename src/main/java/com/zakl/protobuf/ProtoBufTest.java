package com.zakl.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-03-31 20:58
 **/
public class ProtoBufTest {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        //构建Student对象
        DateInfo.Student student = DateInfo.Student.newBuilder().setName("张三").setAge(18).setAddress("海安A606").build();

        //将创建的student对象序列化位字节数组
        byte[] studentbytes = student.toByteArray();

        //将序列化数组反序列化位正常的Student对象
        DateInfo.Student student1 = DateInfo.Student.parseFrom(studentbytes);

        for (byte studentbyte : studentbytes) {
            System.out.println(studentbyte);
        }

        System.out.println(student1.getAddress()+student1.getName()+student.getAge());
    }
}
