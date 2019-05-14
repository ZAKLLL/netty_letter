package com.zakl.netty.grpc;

import com.zakl.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-03 19:43
 **/
public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();

        //同步调用，非流式调用
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        //异步调用
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);


        //实例参数调用，实例返回
        MyResponse realNameByUserName = blockingStub.getRealNameByUserName(MyRequest.newBuilder().setUsername("张三张三你是谁").build());
        System.out.println(realNameByUserName.getRealname());


        System.out.println("---------");


        //实例调用，流返回
        Iterator<StudentResponse> studentsBuAge = blockingStub.getStudentsBuAge(StudentRequest.newBuilder().setAge(17).build());
        while (studentsBuAge.hasNext()) {
            System.out.println(studentsBuAge.next().toString());
        }

        System.out.println("----------");


        //流式调用，实例返回 ,需要异步调用
        StreamObserver<StudentResponseList> responseListStreamObserver = new StreamObserver<StudentResponseList>() {

            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(studentResponse -> {
                    System.out.println(studentResponse.getAge());
                    System.out.println(studentResponse.getCity());
                    System.out.println(studentResponse.getName());
                });
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentWrapperByAges(responseListStreamObserver);

        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(10).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());

        //当发送流结束后，回调服务端的onCompleted
        studentRequestStreamObserver.onCompleted();


        Thread.sleep(50000);

        System.out.println("-------------");

        //双向流传输
        StreamObserver<StudentRequest> requestStreamObserver = stub.getStudentWrapperByAges2(new StreamObserver<StudentResponse>() {
            @Override
            public void onNext(StudentResponse value) {
                System.out.println(value.getName() + value.getCity() + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });

        for (int i = 0; i < 10; i++) {
            requestStreamObserver.onNext(StudentRequest.newBuilder().setAge(10 + i).build());
            Thread.sleep(1000);
        }
        requestStreamObserver.onCompleted();
        Thread.sleep(5000);
    }

}
