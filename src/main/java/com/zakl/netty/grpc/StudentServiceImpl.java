package com.zakl.netty.grpc;

import com.zakl.proto.*;
import io.grpc.stub.StreamObserver;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-03 19:24
 **/
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    Logger logger = Logger.getLogger(this.getClass());


    @Override
    public void getRealNameByUserName(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息： " + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }

    @Override //单例请求，流失返回
    public void getStudentsBuAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response1 = StudentResponse.newBuilder().setAge("17").setCity("珠海").setName("二狗").build();
        StudentResponse response2 = StudentResponse.newBuilder().setAge("17").setCity("背景").setName("网三").build();
        StudentResponse response3 = StudentResponse.newBuilder().setAge("18").setCity("上海").setName("李二").build();
        StudentResponse response4 = StudentResponse.newBuilder().setAge("19").setCity("广州").setName("十大").build();
        StudentResponse response5 = StudentResponse.newBuilder().setAge("16").setCity("重庆").setName("二狗").build();
        StudentResponse response6 = StudentResponse.newBuilder().setAge("10").setCity("四川").setName("二狗").build();

        List<StudentResponse> list = new ArrayList<>();
        list.add(response1);
        list.add(response2);
        list.add(response3);
        list.add(response4);
        list.add(response5);
        list.add(response6);

        Stream<StudentResponse> stream = list.stream().filter(x -> Integer.parseInt(x.getAge()) >= request.getAge());

        stream.forEach(x -> responseObserver.onNext(x));
        responseObserver.onCompleted();
    }

    //流式请求,单例返回,使用回调函数
    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {


            @Override
            public void onNext(StudentRequest studentRequest) {
                System.out.println(studentRequest.getAge());
            }

            @Override
            public void onError(Throwable t) {
                logger.info(Level.WARN, t);
            }

            //当客户端完成流式请求的时候调用此方法
            @Override
            public void onCompleted() {
                StudentResponse studentResponse1 = StudentResponse.newBuilder().setName("张三").setAge("17").setCity("珠海").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("王二").setAge("18").setCity("上海").build();
                StudentResponse studentResponse3 = StudentResponse.newBuilder().setName("leave").setAge("19").setCity("北京").build();
                StudentResponse studentResponse4 = StudentResponse.newBuilder().setName("黑天").setAge("17").setCity("广州").build();
                List<StudentResponse> list = Arrays.asList(
                        studentResponse1,
                        studentResponse2,
                        studentResponse3,
                        studentResponse4
                );

                StudentResponseList studentResponseList = StudentResponseList.newBuilder()
                        .addStudentResponse(studentResponse3).addStudentResponse(studentResponse4)
                        .addStudentResponse(studentResponse1).addStudentResponse(studentResponse2).build();

                responseObserver.onNext(studentResponseList);

                //当返回完毕后，此方法调用客户端的onCompleted();
                responseObserver.onCompleted();
            }
        };
    }

    //流式请求，流式返回
    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAges2(StreamObserver<StudentResponse> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println(value.getAge());
                responseObserver.onNext(StudentResponse.newBuilder().setAge(String.valueOf(value.getAge())).setName("张二").setCity("北京").build());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
